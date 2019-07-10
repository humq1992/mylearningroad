package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.service.RouteService;

import java.util.Date;
import java.util.List;

public class RouteServiceImpl implements RouteService {
    RouteDao routeDao = new RouteDaoImpl();
    @Override
    public Route routedetails(int rid) {

        //通过rid找到route对象的基础数值
        Route route = routeDao.findroute(rid);
        //获得cid
        int cid = route.getCid();
        //获得图片集合
        List<RouteImg> list = routeDao.findrouteimg(rid);
        //通过cid找到img对象
        Category category=routeDao.getCategory(cid);
        //设置分类对象
        route.setCategory(category);
        //通过获得的sid获得seller对象
        Seller seller = routeDao.findseller(route.getSid());
        //设置seller
        route.setSeller(seller);
        //设置imglist
        route.setRouteImgList(list);
        return route;
    }

    @Override
    public Favorite isfavorite(int rid, int uid) {
        Favorite favorite = routeDao.isfavorite(rid, uid);
       return favorite;


    }

    @Override
    public void addfavorite(int rid, Date date, int uid) {
        routeDao.addfavorite(rid,date,uid);
        routeDao.updatecount(rid);
    }

    @Override
    public PageBean getrankbyfavorite(String rname, String minprice, String maxprice,int currentpage,int pagesize) {
        if(minprice==null||maxprice==null){
            minprice=null;
            maxprice=null;
        }

        List<Route> list=routeDao.getrankbyfavorite(rname,minprice,maxprice,currentpage,pagesize);
        int count = routeDao.findcount(rname, minprice, maxprice);
        PageBean pb = new PageBean();
        int totalpage=count%pagesize==0?(count/pagesize):(count/pagesize+1);
        pb.setTotalpage(totalpage);
        pb.setPagesize(pagesize);
        pb.setCurrentpage(currentpage);
        pb.setCount(count);
        pb.setRoutes(list);
        return pb;
    }
}
