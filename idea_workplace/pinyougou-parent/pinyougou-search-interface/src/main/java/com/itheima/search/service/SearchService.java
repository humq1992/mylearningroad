package com.itheima.search.service;

import java.util.List;
import java.util.Map;

public interface SearchService {

    public Map search(Map searchMap);
    public void importList(List list);
    /**
     * 删除数据
     * @param
     */
    public void deleteByGoodsIds(List goodsIdList);
}
