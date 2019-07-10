package com.corp.mybatis.test;

import com.corp.mybatis.dao.userdao;
import com.corp.mybatis.domain.User;
import com.corp.mybatis.domain.vo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;


public class test {
    private  InputStream is;
    private  SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private  userdao mapper;


    @Before
    public void init() throws  Exception{
         is = Resources.getResourceAsStream("SqlMapConfig.xml");
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
         sqlSession = sqlSessionFactory.openSession();
         mapper = sqlSession.getMapper(userdao.class);
    }

    @After
    public void destory()throws Exception{
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void findall(){
        List<User> findall = mapper.findall();
        for (User user : findall) {
            System.out.println(user);
        }
    }
    @Test
    public  void findone()throws Exception{
        User user = mapper.findone(42);
        System.out.println(user);
    }
    @Test
    public void addUser()throws Exception{
        User user = new User();
        user.setUsername("尼古拉斯");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("美国");
        System.out.println(user);
        mapper.adduser(user);
        System.out.println(user);



    }
    @Test
    public void update()throws  Exception{
        User user = new User();
        user.setUsername("尼古拉斯");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("美国");
        user.setId(45);
        System.out.println(user);
        mapper.updateuser(user);
        System.out.println(user);

    }
    @Test
    public void findbyvo()throws  Exception{
        User user = new User();
        user.setUsername("尼古拉斯");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("美国");
        user.setId(45);
        vo v = new vo();
        v.setUser(user);
        List<User> findbyvo = mapper.findbyvo(v);
        for (User user1 : findbyvo) {
            System.out.println(user1);

        }

    }

}
