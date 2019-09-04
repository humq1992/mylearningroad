package com.itheima.controller;
import java.util.List;

import com.itheima.PageResult;
import com.itheima.SaveResult;
import com.itheima.service.AddressService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.pojo.TbAddress;



/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/address")
public class AddressController {

	@Reference
	private AddressService addressService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbAddress> findAll(){			
		return addressService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return addressService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param address
	 * @return
	 */
	@RequestMapping("/add")
	public SaveResult add(@RequestBody TbAddress address){
		try {
			addressService.add(address);
			return new SaveResult( "增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult("增加失败",false );
		}
	}
	
	/**
	 * 修改
	 * @param address
	 * @return
	 */
	@RequestMapping("/update")
	public SaveResult update(@RequestBody TbAddress address){
		try {
			addressService.update(address);
			return new SaveResult( "增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult("增加失败",false );
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbAddress findOne(Long id){
		return addressService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public SaveResult delete(Long [] ids){
		try {
			addressService.delete(ids);
			return new SaveResult( "增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult("增加失败",false );
		}
	}
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbAddress address, int page, int rows  ){
		return addressService.findPage(address, page, rows);		
	}



	@RequestMapping("/findListByUserId")
	public List<TbAddress> findListByUserId(){
		String id = SecurityContextHolder.getContext().getAuthentication().getName();
		List<TbAddress> listByUserId = addressService.findListByUserId(id);
		return listByUserId;
	}
}
