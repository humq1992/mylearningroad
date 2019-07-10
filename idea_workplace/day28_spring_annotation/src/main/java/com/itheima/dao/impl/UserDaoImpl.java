package com.itheima.dao.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("userdaoimpl")
public class UserDaoImpl implements IUserDao {
    @Autowired
    private JdbcTemplate jdbctemplate;



    public List<User> findall() {

        List<User> list = jdbctemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    public User findbyid(int id) {

        User user = jdbctemplate.queryForObject("select * from user WHERE id=?", new BeanPropertyRowMapper<User>(User.class),id);
        return user;
    }

    public void adduser(User user) {


        jdbctemplate.update("INSERT into USER VALUES (?,?,?,?)",user.getName(),user.getBirthday(),user.getSex(),user.getAddress());

    }

}
