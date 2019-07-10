package cn.itcast.travel.service;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

import java.util.Date;
import java.util.List;

public interface RouteService {
    public Route routedetails(int rid);

    Favorite isfavorite(int rid, int uid);

    void addfavorite(int rid, Date date, int uid);

    PageBean getrankbyfavorite(String rname, String minprice, String maxprice, int currentpage, int pagesize);
}
