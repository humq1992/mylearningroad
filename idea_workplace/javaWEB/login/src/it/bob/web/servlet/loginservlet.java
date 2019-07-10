package it.bob.web.servlet;

import it.bob.web.domain.User;
import it.bob.web.userDao.userdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        HttpSession session = request.getSession();
        String servecode = (String)session.getAttribute("servecode");
        if(checkcode.equalsIgnoreCase(servecode)){
            User user = new User(username, password);
            userdao userdao = new userdao();
            User user1 = userdao.finduser(user);
            if(user1==null){
                request.setAttribute("up_error","账号或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {
                session.setAttribute("user","成功登陆");
            }


        }else {
            request.setAttribute("cc_error","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
