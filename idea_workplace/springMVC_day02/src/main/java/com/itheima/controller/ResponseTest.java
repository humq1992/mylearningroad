package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/test")
public class ResponseTest {
    @RequestMapping("/testString")
    public String testString(){
        return "success";
        // return "response:/WEB-INF/pages/success.jsp";
        // return "redirect:/WEB-INF/pages/success.jsp";
    }
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //response重定向无法访问WEB-INF下的资源
        // response.sendRedirect("/success.jsp");
        //return不可省去
        return;

    }
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mv=new ModelAndView();
       mv.addObject("msg","shit");
       mv.setViewName("success");//此处会经过视图解析器解析组装

        return  mv;
    }
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println(user);
        user.setUsername("shit");
        user.setAge(40);
        return  user ;
    }
}
