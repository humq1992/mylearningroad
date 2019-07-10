package com.corp.mybatis.dao;

import com.corp.mybatis.domain.User;
import com.corp.mybatis.domain.vo;

import java.util.List;

public interface userdao {
    List<User> findall();
    User findone(Integer uid);
    void adduser(User user);
    void updateuser(User user);
    List<User> findbyvo(vo v);

}
