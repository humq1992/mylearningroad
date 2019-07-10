package cn.bob.client_user.web.servlet;

import cn.bob.client_user.Service.UserService;
import cn.bob.client_user.Service.UserServiceImpl.UserServiceImpl;
import cn.bob.client_user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userservlet")
public class Userservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        UserService userService = new UserServiceImpl();
        List<User> list = userService.findall();
        request.setAttribute("list",list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
