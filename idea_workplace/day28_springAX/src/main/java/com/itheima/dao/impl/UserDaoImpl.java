package com.itheima.dao.impl;


import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Repository("userdaoimpl")
public class UserDaoImpl implements IUserDao {
    @Autowired
    private QueryRunner runner;



    public List<User> findall() {
        List<User> list=null;
        try {
           list = runner.query("select*from user", new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
return list;
    }

    public User findbyid(int id) {

        User user = null;
        try {
            user = runner.query("select * from user WHERE id=?", new BeanHandler<User>(User.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void adduser(User user) {


        try {
            runner.update("INSERT into USER VALUES (?,?,?,?)",user.getUsername(),user.getBirthday(),user.getSex(),user.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
