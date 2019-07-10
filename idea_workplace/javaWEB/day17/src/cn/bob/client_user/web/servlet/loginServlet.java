package cn.bob.client_user.web.servlet;

import cn.bob.client_user.Service.UserService;
import cn.bob.client_user.Service.UserServiceImpl.UserServiceImpl;
import cn.bob.client_user.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService userService=new UserServiceImpl();

        String servecode = (String)request.getSession().getAttribute("servecode");
        if(request.getParameter("verifycode").equalsIgnoreCase(servecode)){
            User u = userService.login(user);
            if(u==null){
                request.setAttribute("login_msg","账号或密码错误");
                //返回登陆界面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else{
                request.setAttribute("user",u);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }


        }else {
            request.setAttribute("login_msg","验证码错误");
            //返回登陆界面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
