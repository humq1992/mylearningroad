package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public String findall() {

        Jedis jedis = JedisUtil.getJedis();
        String s1 = jedis.get("category");
        if(s1==null||s1==""){
            List<Category> list = categoryDao.findall();
            System.out.println("from date base");
            ObjectMapper objectMapper = new ObjectMapper();
            String s=null;
            try {
                s = objectMapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("category",s);
            s1=s;
        }else {
            System.out.println("from jedis");
        }
        jedis.close();

            return s1;
    }

    @Override
    public PageBean findbypage(int cid, int currentpage, int pagesize, String rname) {
        int begin=(currentpage-1)*pagesize;
        List<Route> routes = categoryDao.findroutes(cid, begin, pagesize,rname);
        int count = categoryDao.findcount(cid,rname);
        int totalpage=0;
        if(count%pagesize==0){
             totalpage=(count/pagesize);
        }else {
             totalpage=(count/pagesize)+1;
        }
        PageBean pageBean = new PageBean();
        pageBean.setCount(count);
        pageBean.setCurrentpage(currentpage);
        pageBean.setPagesize(pagesize);
        pageBean.setRoutes(routes);
        pageBean.setTotalpage(totalpage);
        return pageBean;

    }


}
