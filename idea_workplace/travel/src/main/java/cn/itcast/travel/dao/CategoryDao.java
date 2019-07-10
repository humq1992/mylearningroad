package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.domain.Route;

import java.util.List;

public interface CategoryDao {
    public List<Category> findall();
    public int findcount(int cid,String route);
    public List<Route> findroutes(int cid,int begin,int pagesize,String route);
}
