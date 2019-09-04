package com.itheima.controller;
import java.util.List;

import com.itheima.PageResult;
import com.itheima.SaveResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.pojo.TbContent;
import com.itheima.service.ContentService;


/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/content")
public class ContentController {

	@Reference
	private ContentService contentService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbContent> findAll(){			
		return contentService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return contentService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param content
	 * @return
	 */
	@RequestMapping("/add")
	public SaveResult add(@RequestBody TbContent content){
		try {
			contentService.add(content);
			return new SaveResult( "增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult( "增加失败",false);
		}
	}
	
	/**
	 * 修改
	 * @param content
	 * @return
	 */
	@RequestMapping("/update")
	public SaveResult update(@RequestBody TbContent content){
		try {
			contentService.update(content);
			return new SaveResult("修改成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult( "修改失败",false);
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbContent findOne(Long id){
		return contentService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public SaveResult delete(Long [] ids){
		try {
			contentService.delete(ids);
			return new SaveResult("删除成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult("删除失败",false);
		}
	}
	
		/**
	 * 查询+分页

	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbContent content, int page, int rows  ){
		return contentService.findPage(content, page, rows);		
	}
	
}
