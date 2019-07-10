package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

public interface IUserService {
    List<User> findall();
    User findbyid(int id);
    void adduser(User user);
}
