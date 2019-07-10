package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class ControllerTest {
    @Autowired
    private IUserService userService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv =new ModelAndView();
        List<User> list = userService.findAll();
        mv.addObject("list",list);
        mv.setViewName("success");
        return mv;
    }
    @RequestMapping("/addUser")
    public  void addUser(User user, HttpServletResponse response, HttpServletRequest request) throws IOException {
        userService.addUser(user);
        response.sendRedirect(request.getContextPath()+"/user/findAll");

        return;
    }

}
