package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.mapper.TbItemMapper;
import com.itheima.mapper.TbOrderItemMapper;
import com.itheima.pojo.TbItem;
import com.itheima.pojo.TbOrderItem;
import com.itheima.pojogroup.Cart;
import com.itheima.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private TbItemMapper tbItemMapper;


    @Override
    public List<Cart> addGoodsToCartList(List<Cart> cartList, Long itemId, Integer num) {
        //1.根据商品 SKU ID 查询 SKU 商品信息
        TbItem item = tbItemMapper.selectByPrimaryKey(itemId);
        if(item==null){throw new RuntimeException("商品不存在");}
        if(!item.getStatus().equals("1")){throw new RuntimeException("商品状态异常");}
        //2.获取商家 ID
        String sellerId = item.getSellerId();
        //3.根据商家 ID 判断购物车列表中是否存在该商家的购物车
        boolean exist=false;
        int index=0;
        for (int i=0; i<cartList.size(); i++) {
            if(cartList.get(i).getSellerId().equals(sellerId)){
                exist=true;
               index=i ;}
        }
        //4.如果购物车列表中不存在该商家的购物车
        //4.1 新建购物车对象
        //4.2 将新建的购物车对象添加到购物车列表
        if(exist==false){
            Cart cart = new Cart();
            cart.setSellerId(sellerId);
            cart.setSellerName(item.getSeller());
            List<TbOrderItem> orderItems = new ArrayList();
            TbOrderItem orderItem=creatOrderItem(item, num);
            orderItems.add(orderItem);
            cart.setOrderItemList(orderItems);//此时orderItemList中只有你添加的一个对象

        }

        //5.如果购物车列表中存在该商家的购物车
        //5.1查询购物车明细列表中是否存在该商品
        //5.2. 如果有，在原购物车明细上添加数量，更改金额
        if(exist==true){//购物车列表中存在该商家的购物车
            Cart cart = cartList.get(index);
            List<TbOrderItem> orderItemList = cart.getOrderItemList();
            int k=-1;
            for (int i=0; i<orderItemList.size() ; i++) {
                if(orderItemList.get(i).getItemId().equals(itemId)){
                    Integer num1 = orderItemList.get(i).getNum();
                    orderItemList.get(i).setNum(num+num1);
                    k=i;
                }
            }

            //5.1. 如果没有，增加购物车明细中的商品orderitem
            if(k==-1){
                orderItemList.add(creatOrderItem(item,num));
            }

        }
        return cartList;

    }
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public List<Cart> findCartListFromRedis(String username) {

        System.out.println("从 redis 中提取购物车数据....."+username);
        List<Cart> cartList = (List<Cart>)
                redisTemplate.boundHashOps("cartList").get(username);
        if(cartList==null){
            cartList=new ArrayList();
        }
        return cartList;
    }
    @Override
    public void saveCartListToRedis(String username, List<Cart> cartList) {
        System.out.println("向 redis 存入购物车数据....."+username);
        redisTemplate.boundHashOps("cartList").put(username, cartList);
    }

    @Override
    public List<Cart> mergeCartList(List<Cart> cartList1, List<Cart> cartList2) {

        System.out.println("合并购物车");
        for(Cart cart: cartList2){
            for(TbOrderItem orderItem:cart.getOrderItemList()){
                cartList1=
                        addGoodsToCartList(cartList1,orderItem.getItemId(),orderItem.getNum());
            }
        }
        return cartList1;

    }

    @Autowired
    private TbOrderItemMapper orderItemMapper;
    //定义私有方法
    private  TbOrderItem creatOrderItem(TbItem item,Integer num){
        if(num<=0){throw  new RuntimeException("数量异常");}
        //在这里尚未定义  orderItem的ID和orderid 所以无法插入数据库只是再页面上做展示
        //具体的上述2项id 需要根据支付业务时由算法生成避免分布式集群时由于ID重复
        //当然也可以使用uuid来配置简化；
        TbOrderItem orderItem = new TbOrderItem();
        orderItem.setGoodsId(item.getGoodsId());
        orderItem.setItemId(item.getId());
        orderItem.setNum(num);
        orderItem.setPicPath(item.getImage());
        orderItem.setPrice(item.getPrice());
        orderItem.setSellerId(item.getSellerId());
        orderItem.setTitle(item.getTitle());
        orderItem.setTotalFee(new BigDecimal(item.getPrice().doubleValue()*num.doubleValue()));
        return orderItem;

    }
}
