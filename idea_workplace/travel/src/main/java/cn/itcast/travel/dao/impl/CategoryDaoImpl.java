package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Category> findall() {
        List<Category> list=null;
        try {
            list = jdbcTemplate.query("select*from tab_category ORDER by cid", new BeanPropertyRowMapper<>(Category.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int findcount(int cid,String route) {
        int integer = 0;
        String s="select count(*) from tab_route where 1=1";
        StringBuilder stringBuilder = new StringBuilder(s);
        ArrayList parames = new ArrayList();
        if(cid!=0){
            stringBuilder.append(" and cid=? ");
            parames.add(cid+"");
        }
        if(route!=null&&route.length()!=0){
            stringBuilder.append(" and rname like ? ");
            parames.add("%"+route+"%");
        }
        String sql = stringBuilder.toString();
        try {
            integer = jdbcTemplate.queryForObject(sql,Integer.class,parames.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return integer;
    }

    @Override
    public List<Route> findroutes(int cid, int begin, int pagesize,String route) {
        List<Route> list = null;
        String s="select*from tab_route where 1=1";
        StringBuilder stringBuilder = new StringBuilder(s);
        ArrayList parames = new ArrayList();
        if(cid!=0){
            stringBuilder.append(" and cid=? ");
            parames.add(cid+"");
        }
        if(route!=""){
            stringBuilder.append(" and rname like ? ");
            parames.add("%"+route+"%");
        }
        stringBuilder.append(" limit ?,? ");
        parames.add(begin);
        parames.add(pagesize);
        String sql = stringBuilder.toString();
        try {
            list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Route.class), parames.toArray());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }
}
