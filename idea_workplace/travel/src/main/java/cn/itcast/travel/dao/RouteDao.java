package cn.itcast.travel.dao;

import cn.itcast.travel.domain.*;

import java.util.Date;
import java.util.List;

public interface RouteDao {
    public Route findroute(int rid);
    public List<RouteImg> findrouteimg(int rid);

    Category getCategory(int cid);

    Seller findseller(int sid);


    Favorite isfavorite(int rid,int uid);

    void addfavorite(int rid, Date date, int uid);

    void updatecount(int rid);

    List<Route> getrankbyfavorite(String rname, String minprice, String maxprice,int currentpage,int pagesize);

    int findcount(String rname, String minprice, String maxprice);
}
