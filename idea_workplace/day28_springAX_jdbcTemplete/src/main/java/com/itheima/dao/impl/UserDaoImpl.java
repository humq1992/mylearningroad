package com.itheima.dao.impl;


import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("userdaoimpl")
public class UserDaoImpl implements IUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;



    public List<User> findall() {
        List<User> list=null;
        try {
           list = jdbcTemplate.query("select*from user", new BeanPropertyRowMapper<User>(User.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
return list;
    }

    public User findbyid(int id) {

        User user = null;
        try {
            user = jdbcTemplate.queryForObject("select * from user WHERE id=?", new BeanPropertyRowMapper<User>(User.class),id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void adduser(User user) {


        try {
            jdbcTemplate.update("INSERT into USER VALUES (?,?,?,?)",user.getUsername(),user.getBirthday(),user.getSex(),user.getAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
