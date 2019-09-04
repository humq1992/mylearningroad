package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.PageResult;
import com.itheima.SaveResult;
import com.itheima.pojo.TbGoods;
import com.itheima.pojogroup.Goods;
import com.itheima.service.GoodsService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
		Goods goods2 = goodsService.findOne(goods.getGoods().getId());
		//获取当前登录的商家 ID
		String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
		//如果传递过来的商家 ID 并不是当前登录的用户的 ID,则属于非法操作
		if(!goods2.getGoods().getSellerId().equals(sellerId)
				||  !goods.getGoods().getSellerId().equals(sellerId) ){
			return new SaveResult("操作非法",false );
		}
		try {
			goodsService.update(goods);
			return new SaveResult("增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult( "增加失败",false);
		}
	}	
	
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
	public SaveResult delete(Long [] ids){
		try {
			goodsService.delete(ids);
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
		String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
		goods.setSellerId(sellerId);
		return goodsService.findPage(goods, page, rows);		
	}
	
}
