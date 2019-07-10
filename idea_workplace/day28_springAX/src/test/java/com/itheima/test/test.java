package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationConfig.xml")
public class test {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void findall(){
        List<User> list = userService.findall();
        System.out.println(list);
    }
}
