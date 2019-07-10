package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/param")
public class ControllerTest {
    @RequestMapping("/finduser")
    public String findUser(User user){
        System.out.println(user);
        return "success";
    }
}
