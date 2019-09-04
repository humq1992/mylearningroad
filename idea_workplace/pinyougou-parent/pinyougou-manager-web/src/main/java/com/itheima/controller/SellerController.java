package com.itheima.controller;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.pojo.TbSeller;
import com.itheima.service.SellerService;

import com.itheima.PageResult;
import com.itheima.SaveResult;;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

	@Reference
	private SellerService sellerService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbSeller> findAll(){			
		return sellerService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return sellerService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param seller
	 * @return
	 */
	@RequestMapping("/add")
	public SaveResult add(@RequestBody TbSeller seller){
		  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
		  String password = passwordEncoder.encode(seller.getPassword()); 
		  seller.setPassword(password); 
		  
		try {
			sellerService.add(seller);
			return new SaveResult("增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult( "增加失败",false);
		}
	}
	
	/**
	 * 修改
	 * @param seller
	 * @return
	 */
	@RequestMapping("/update")
	public SaveResult update(@RequestBody TbSeller seller){
		try {
			sellerService.update(seller);
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
	public TbSeller findOne(String id){
		return sellerService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public SaveResult delete(String [] ids){
		try {
			sellerService.delete(ids);
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
	public PageResult search(@RequestBody TbSeller seller, int page, int rows  ){
		return sellerService.findPage(seller, page, rows);		
	}
	@RequestMapping("/updateStatus")
	public  SaveResult updataStatus(String sellerId, String status){
		try {
			sellerService.updateStatus(sellerId,  status);
			return new SaveResult("增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult( "增加失败",false);
		}
	}
	
}
