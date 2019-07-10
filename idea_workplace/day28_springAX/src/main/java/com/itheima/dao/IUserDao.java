package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findall();
    User findbyid(int id);
    void adduser(User user);


}
