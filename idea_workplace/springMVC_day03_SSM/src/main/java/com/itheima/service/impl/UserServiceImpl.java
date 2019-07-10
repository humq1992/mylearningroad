package com.itheima.service.impl;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public List<User> findAll() {
        List<User> users = userDao.findall();
        return users;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void addUser(User user) {
        userDao.addUser(user);
       // int i=1/0;

    }
}
