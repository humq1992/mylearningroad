package com.itheima.service.impl;

import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDaoImpl userdaoimpl;

    public void setUserDao(UserDaoImpl userDao) {
        this.userdaoimpl = userDao;
    }

    public List<User> findall() {
        List<User> list = userdaoimpl.findall();
        return list;
    }

    public User findbyid(int id) {
        User u = userdaoimpl.findbyid(id);
        return u;
    }

    public void adduser(User user) {
        userdaoimpl.adduser(user);

    }
}
