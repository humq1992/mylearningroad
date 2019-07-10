package cn.bob.client_user.web.servlet;

import cn.bob.client_user.Service.UserService;
import cn.bob.client_user.Service.UserServiceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int uid = Integer.parseInt(request.getParameter("uid"));
        UserService userService = new UserServiceImpl();
        userService.delete(uid);
        response.sendRedirect(request.getContextPath()+"/userservlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
