package com.itheima.controller;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.TbItem;
import com.itheima.pojogroup.Goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.pojo.TbGoods;
import com.itheima.service.GoodsService;

import com.itheima.PageResult;
import com.itheima.SaveResult;

import javax.jms.*;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Reference
	private GoodsService goodsService;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Destination queueSolrDestination;
	@Autowired
	private  Destination queueDeleteSolrDestination;
	@Autowired
	private  Destination topicPageDestination;



	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbGoods> findAll(){			
		return goodsService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return goodsService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param goods
	 * @return
	 */
	@RequestMapping("/add")
	public SaveResult add(@RequestBody Goods goods){
		//在此处需要设置商家的ID 通过security获取登陆的信息
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		goods.getGoods().setSellerId(name);
		try {
			goodsService.add(goods);
			return new SaveResult("增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult( "增加失败",false);
		}
	}
	
	/**
	 * 修改
	 * @param goods
	 * @return
	 */
	@RequestMapping("/update")
	public SaveResult update(@RequestBody Goods goods){
		try {
			goodsService.update(goods);
			return new SaveResult("增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult( "增加失败",false);
		}
	}
	@Autowired
	private Destination topicPageDeleteDestination;//用于删除静态网页的消息
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Goods findOne(Long id){
		return goodsService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public SaveResult delete(final Long [] ids){
		try {
			goodsService.delete(ids);

			jmsTemplate.send(queueDeleteSolrDestination, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					return session.createObjectMessage(ids);
				}
			});
			//删除页面
			jmsTemplate.send(topicPageDeleteDestination, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					return session.createObjectMessage(ids);
				}
			});

			//	itemSearchService.deleteByGoodsIds(Arrays.asList(ids));
			return new SaveResult("增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult( "增加失败",false);
		}
	}
	
		/**
	 * 查询+分页

	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbGoods goods, int page, int rows  ){
		return goodsService.findPage(goods, page, rows);		
	}
	@RequestMapping("/updateStatus")
	public SaveResult updateStatus(Long[] ids,String status){
		try {
			goodsService.updateStatus(ids, status);
			//按照 SPU ID 查询 SKU 列表(状态为 1)
			if(status.equals("1")){//审核通过



				List<TbItem> itemList =
						goodsService.findItemListByGoodsIdandStatus(ids, status);
				//调用搜索接口实现数据批量导入
				if(itemList.size()>0){
				final 	String json= JSON.toJSONString(itemList);
					jmsTemplate.send(queueSolrDestination,new MessageCreator() {
						@Override
						public Message createMessage(Session session) throws JMSException {
							TextMessage message = session.createTextMessage(json);
							return message;
						}
					});


				}else{
					System.out.println("没有明细数据");
				}
				//发送静态页面的ids
				for (Long goodsid : ids) {
					jmsTemplate.send(topicPageDestination, new MessageCreator() {
						@Override
						public Message createMessage(Session session) throws JMSException {
							TextMessage textMessage = session.createTextMessage(goodsid + "");
							return textMessage;
						}
					});

				}
			}
			return new SaveResult("修改状态成功",true );
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult("修改状态失败",false);
		}
	}



}
