package cn.bob.client_user.web.servlet;

import cn.bob.client_user.Service.UserService;
import cn.bob.client_user.Service.UserServiceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteselectedServlet")
public class DeleteselectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        
        String[] ids = request.getParameterValues("id");
        UserService userService = new UserServiceImpl();
        userService.deleteselected(ids);
        response.sendRedirect(request.getContextPath()+"/userservlet");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
