package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ErrorMessage;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String checkcode_server =(String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        String check = request.getParameter("check");
        ErrorMessage msg = new ErrorMessage();
        if(!check.equalsIgnoreCase(checkcode_server)){

            msg.setMessage("验证码错误");
            msg.setFlag(false);

        }else {
            //验证码正确
            UserServiceImpl userService = new UserServiceImpl();
            User U = userService.login(request.getParameter("username"), request.getParameter("passerword"));
            if(U!=null){


                msg.setMessage(request.getParameter("username"));
                msg.setFlag(true);
                request.getSession().setAttribute("User",request.getParameter("username"));
            }else {

                msg.setMessage("账号或密码错误或未激活");
                msg.setFlag(false);

            }



        }
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String msg_json = objectMapper.writeValueAsString(msg);
        response.getWriter().write(msg_json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
