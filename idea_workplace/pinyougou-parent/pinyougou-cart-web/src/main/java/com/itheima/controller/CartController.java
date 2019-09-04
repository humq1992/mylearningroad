package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.itheima.SaveResult;
import com.itheima.pojogroup.Cart;
import com.itheima.service.CartService;
import com.itheima.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Reference(timeout = 6000)
    private CartService cartService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @RequestMapping("/findCartList")
    public List<Cart> findCartList(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();


            String cookieValue = CookieUtil.getCookieValue(request, "cartList", "utf-8");
            if (cookieValue == null || cookieValue.equals("")) {
                cookieValue = "[]";
            }
            List<Cart> cartList_cookie = JSON.parseArray(cookieValue, Cart.class);
        if(username.equals("anonymousUser")) {//如果未登录
            return cartList_cookie;
        }else {//如果登陆了
            List<Cart> cartList_redis =cartService.findCartListFromRedis(username);//从redis 中提取
            if(cartList_cookie.size()>0){//如果本地存在购物车
                //合并购物车
                cartList_redis=cartService.mergeCartList(cartList_redis, cartList_cookie);
                //清除本地 cookie 的数据
                CookieUtil.deleteCookie(request, response, "cartList");
                //将合并后的数据存入 redis
                cartService.saveCartListToRedis(username, cartList_redis);
            }
            return cartList_redis;  }

    }


    @RequestMapping("/addGoodsToCartList")
    @CrossOrigin(origins="http://localhost:9105")
    public SaveResult addGoodsToCartList(Long itemId, Integer num){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        //response.setHeader("Access-Control-Allow-Origin", "http://localhost:9105");
        //response.setHeader("Access-Control-Allow-Credentials", "true");
        try {
            List<Cart> cartList = findCartList();//从cookie中获取购物车列表；
            cartList= cartService.addGoodsToCartList(cartList,itemId,num);
            if(username.equals("anonymousUser")) { //如果是未登录，保存到 cookie
                CookieUtil.setCookie(request, response, "CartList", JSON.toJSONString(cartList), 3600 * 24, "utf-8");
            }else{cartService.saveCartListToRedis(username, cartList);}
                return new SaveResult("添加成功",true);
        } catch (Exception e) {
            e.printStackTrace();
            return  new SaveResult("添加失败",false);
        }


    }


}
