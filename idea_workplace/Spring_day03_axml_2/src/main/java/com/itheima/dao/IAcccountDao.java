package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface IAcccountDao {
    public List findaccout();
    Account findbyname(String name);
    void updataaccount(String name,float money);
    void transfer(String sname,String tname, float money );
}
