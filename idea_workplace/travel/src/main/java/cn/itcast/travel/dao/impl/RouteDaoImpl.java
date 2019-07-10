package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public Route findroute(int rid) {
        String sql = "select * from tab_route where rid=?";
        Route route = null;
        try {
            route = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Route.class), rid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return route;
    }

    @Override
    public List<RouteImg> findrouteimg(int rid) {
        String sql = "select * from tab_route_img where rid=?";
        List<RouteImg> list = null;
        try {
            list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(RouteImg.class), rid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Category getCategory(int cid) {
        Category category = null;
        try {
            category = jdbcTemplate.queryForObject("select * from tab_category where cid=?", new BeanPropertyRowMapper<>(Category.class), cid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Seller findseller(int sid) {
        Seller seller = null;
        try {
            seller = jdbcTemplate.queryForObject("select * from tab_seller where sid=?", new BeanPropertyRowMapper<>(Seller.class), sid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return seller;
    }

    @Override
    public Favorite isfavorite(int rid, int uid) {
        Favorite favorite = null;
        try {
            favorite = jdbcTemplate.queryForObject("select*from tab_favorite where uid=? and rid=?", new BeanPropertyRowMapper<>(Favorite.class), uid, rid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return favorite;
    }

    @Override
    public void addfavorite(int rid, Date date, int uid) {
        try {
            jdbcTemplate.update("insert into tab_favorite VALUES (?,?,?)", rid, date, uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatecount(int rid) {
        try {
            jdbcTemplate.update("UPDATE tab_route set COUNT =count+1 where rid=?", rid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Route> getrankbyfavorite(String rname, String minprice, String maxprice, int currentpage, int pagesize) {
        String s="select * from tab_route  where 1=1 ";
        StringBuilder stringBuilder = new StringBuilder(s);
        List list = new ArrayList();
        if(rname!=null&&rname.length()!=0){
            stringBuilder.append(" and rname like ? ");
            list.add("%"+rname+"%");

        }
        if (minprice!=null&&minprice.length()!=0){
            stringBuilder.append(" and price between ? and ?");
            list.add(minprice);
            list.add(maxprice);
        }
        stringBuilder.append(" order by count DESC ");
        stringBuilder.append(" limit ?,? ");
        list.add((currentpage-1)*pagesize);
        list.add(pagesize);

        String sql = stringBuilder.toString();
        List<Route> routes = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class), list.toArray());

        return routes;
    }

    @Override
    public int findcount(String rname, String minprice, String maxprice) {
        String s="select count(*) from tab_route where 1=1 ";
        StringBuilder stringBuilder = new StringBuilder(s);
        List list = new ArrayList();

        if(rname!=null&&rname.length()!=0){
            stringBuilder.append(" and rname like ? ");
            list.add("%"+rname+"%");

        }
        if (minprice!=null&&minprice.length()!=0){
            stringBuilder.append(" and price between ? and ?");
            list.add(minprice);
            list.add(maxprice);
        }
        String sql = stringBuilder.toString();
        Integer count = null;
        try {
            count = jdbcTemplate.queryForObject(sql, Integer.class, list.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return count;
    }


}
