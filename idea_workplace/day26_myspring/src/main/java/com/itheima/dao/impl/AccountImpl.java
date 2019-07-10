package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class AccountImpl implements AccountDao {
    private String name;
    private Integer age;
    private Date birthday;
    private List list;
    @Autowired
    @Qualifier
    private AccountService ac;
    public void find() {
        System.out.println("方法执行了");
    }

    public AccountImpl(String name, Integer age, Date birthday, List list, Map map) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.list = list;
        this.map = map;
    }

    public AccountImpl() {
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "AccountImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
