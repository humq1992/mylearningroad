package cn.itheima.servlet;

import cn.itheima.dao.Userdao;
import cn.itheima.domain.User;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/loginservlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        User user = new User();
//        user.setName(name);
//        user.setPassword(password);
        //第二种方式通过导入阿帕奇bean包来封装user对象
        User user=new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Userdao userdao = new Userdao();
        User u = userdao.getUser(user);

        if(u==null){

            response.sendRedirect("/day14/faillogin.html");

        }else{
            request.setAttribute("message",u);
            String path = request.getContextPath();
            response.sendRedirect(path+"/successloginServlet");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
