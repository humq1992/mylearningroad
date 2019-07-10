package com.itheima;


import com.itheima.domain.User;
import com.itheima.service.impl.UserServiceImpl;
import conifg.applicationconfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= applicationconfig.class)
public class test {
    @Autowired
    private UserServiceImpl userservice=null;
    @Test
    public void find(){


        List<User> findall = userservice.findall();
        System.out.println(findall);

    }
}
