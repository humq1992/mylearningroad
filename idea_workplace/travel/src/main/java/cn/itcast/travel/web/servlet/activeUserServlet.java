package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeUserServlet")
public class activeUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("activeCode");
        UserServiceImpl userService = new UserServiceImpl();
        if(uuid!=null&&uuid!=""){
        userService.activUser(uuid);
        response.getWriter().print("激活完成<a href='http://127.0.0.1/travel/login.html'>点击跳转登录</a>");


    }else {response.getWriter().print("<h1>激活失败，请联系管理员!</h1>");}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
