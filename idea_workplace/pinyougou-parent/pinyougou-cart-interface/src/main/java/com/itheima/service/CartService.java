package com.itheima.service;

import com.itheima.pojogroup.Cart;

import java.util.List;

public interface CartService {
    //分析：优先完成将用户选择的item加入购物车中的接口，返回至购物车页面需要cart集合
    //参数需要 传入本来用户的购物车，以判定是否已经选择该商家的商品，
    //        itemID 来查询商品的详细信息，获得价格 缩略图等信息
    //        数目 确定购买数量
    public List<Cart> addGoodsToCartList(List<Cart> cartList,Long itemId,Integer num);
    public List<Cart> findCartListFromRedis(String username);
    public void saveCartListToRedis(String username,List<Cart> cartList);
    public List<Cart> mergeCartList(List<Cart> cartList1,List<Cart> cartList2);

}
