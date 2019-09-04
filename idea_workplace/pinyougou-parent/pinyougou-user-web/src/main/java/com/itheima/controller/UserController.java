package com.itheima.controller;
import java.util.List;

import com.itheima.PageResult;
import com.itheima.SaveResult;
import com.itheima.utils.PhoneFormatCheckUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.pojo.TbUser;
import com.itheima.service.UserService;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Reference
	private UserService userService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbUser> findAll(){			
		return userService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows){
		return userService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param user
	 * @return
	 */
	@RequestMapping("/add")
	public SaveResult add(@RequestBody TbUser user,String smscode){
		try {
			if(userService.checkSmsCode(user.getPhone(),smscode)==false){
				return new SaveResult("增加失败",false);
			};
			userService.add(user);
			return new SaveResult( "增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult("增加失败",false);
		}
	}
	
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	@RequestMapping("/update")
	public SaveResult update(@RequestBody TbUser user){
		try {
			userService.update(user);
			return new SaveResult( "增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult("增加失败",false);
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbUser findOne(Long id){
		return userService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public SaveResult delete(Long [] ids){
		try {
			userService.delete(ids);
			return new SaveResult( "增加成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult("增加失败",false);
		}
	}
	
		/**
	 * 查询+分页

	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbUser user, int page, int rows  ){
		return userService.findPage(user, page, rows);		
	}
	//发送短信按钮需要验证手机号是否合法
	@RequestMapping("/sendCode")
	public SaveResult sendCode(String phone){
		if(!PhoneFormatCheckUtils.isPhoneLegal(phone)){
			return new SaveResult("请输入正确电话",false);
		}
		try {
			userService.creatSmsCode(phone);
			return new SaveResult("发送成功",true);
		} catch (Exception e) {
			e.printStackTrace();
			return new SaveResult("发送失败",false);
		}

	}
}
