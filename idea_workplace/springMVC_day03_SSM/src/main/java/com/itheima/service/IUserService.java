package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

public interface IUserService  {
    List<User> findAll();
    void addUser(User user);
}
