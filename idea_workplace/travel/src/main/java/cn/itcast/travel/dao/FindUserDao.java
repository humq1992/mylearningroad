package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

import java.util.List;

public interface FindUserDao {
    public User  findUser(User user);
    public void addUser(User user);
    public void activeuser(String uuid);
    public  User login(String username,String password);
    public  User findbyusername(String username);
;}
