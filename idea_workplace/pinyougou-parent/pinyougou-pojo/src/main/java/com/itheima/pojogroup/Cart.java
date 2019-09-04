package com.itheima.pojogroup;



import com.itheima.pojo.TbOrderItem;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {
    private String sellerId;//商家Id
    private String sellerName;//商家名称；
    private List<TbOrderItem> orderItemList;//购物车明细；为同一商家购物车里面的商品信息集合Order表的内容则主要是订单本身的信息
    //一般一个商家会定义一个order 然后每个order中会有 明细列表，一般用户购买多家商家物品则可能再页面中呈现出 一个order集合，遍历order集合
    //中还有orderitem列表来展示商品；

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public List<TbOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<TbOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
