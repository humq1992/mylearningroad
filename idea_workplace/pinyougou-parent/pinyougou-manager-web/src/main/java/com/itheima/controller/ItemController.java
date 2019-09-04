package com.itheima.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.pojo.TbItem;
import com.itheima.service.ItemService;

import com.itheima.PageResult;
import com.itheima.SaveResult;;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/item")
public class ItemController {

	@Reference
	private ItemService itemService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbItem> findAll(){			
		return itemService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return itemService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param item
	 * @return
	 */
	@RequestMapping("/add")
	public SaveResult add(@RequestBody TbItem item){
		try {
			itemService.add(item);
			return new SaveResult("增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult( "增加失败",false);
		}
	}
	
	/**
	 * 修改
	 * @param item
	 * @return
	 */
	@RequestMapping("/update")
	public SaveResult update(@RequestBody TbItem item){
		try {
			itemService.update(item);
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
	public TbItem findOne(Long id){
		return itemService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public SaveResult delete(Long [] ids){
		try {
			itemService.delete(ids);
			return new SaveResult("增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult( "增加失败",false);
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbItem item, int page, int rows  ){
		return itemService.findPage(item, page, rows);		
	}
	
}
