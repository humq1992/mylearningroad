package com.itheima.pojogroup;

import com.itheima.pojo.TbGoods;
import com.itheima.pojo.TbGoodsDesc;
import com.itheima.pojo.TbItem;

import java.io.Serializable;
import java.util.List;

public class Goods  implements Serializable{
    private TbGoods goods;//商品SPU名
    private TbGoodsDesc goodsDesc;//商品的扩展属性
    private List<TbItem> itemList;//sku集合

    public TbGoods getGoods() {
        return goods;
    }

    public void setGoods(TbGoods goods) {
        this.goods = goods;
    }

    public TbGoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(TbGoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<TbItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<TbItem> itemList) {
        this.itemList = itemList;
    }
}
