package com.itheima.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.pojo.TbSeller;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	//此处无法使用@reference来远程调用 原因为springsecurity在调用包时候和 把该类扫入spring容器中有顺序矛盾；
	//必须先通过dubbo先把sellerService申请回来 才可以把该类扫入bean  从而被SPRINGSECURITY使用；
	private SellerService sellerService;
	
	
	 public void setSellerService(SellerService sellerService) {
	  this.sellerService = sellerService; }
	 
		 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("经过了 UserDetailsServiceImpl"); 
		  //构建角色列表 
		  List<GrantedAuthority> grantAuths=new ArrayList(); 
		  grantAuths.add(new SimpleGrantedAuthority("ROLE_SELLER")); 
		  //得到商家对象 
		  TbSeller seller = sellerService.findOne(username); 
		  if(seller!=null){ 
		   if(seller.getStatus().equals("1")){ 
		    return new User(username,seller.getPassword(),grantAuths); 
		   }else{ 
		    return null;
		
		   }    
		  }else{ 
		   return null; 
		  } 
		 }
	}


