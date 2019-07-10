package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ErrorMessage;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import cn.itcast.travel.util.Md5Util;
import cn.itcast.travel.util.UuidUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/UserServlet/*")
public class UserServlet extends BaseServlet {
    public void regist(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        Map<String, String[]> parameterMap = request.getParameterMap();
        //先判断验证码
        String checkcode = request.getParameter("check");
        HttpSession session = request.getSession();
        ErrorMessage errorMessage=new ErrorMessage();
        UserService userService = new UserServiceImpl();
        String s =(String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if(!checkcode.equalsIgnoreCase(s)){
            errorMessage.setFlag(false);
            errorMessage.setMessage("验证码错误");
        }else {//验证码正确执行查找
            User u=new User();
            try {
                BeanUtils.populate(u,parameterMap);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            //查找后返回的对象
            User user = userService.extinctedUsername(u);
            if(user==null){

                u.setStatus("N");
                try {
                    String s1 = Md5Util.encodeByMd5(u.getPassword());
                    u.setPassword(s1);
                    String uuid = UuidUtil.getUuid();
                    u.setCode(uuid);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                userService.addUser(u);
                errorMessage.setFlag(true);
            }else {
                errorMessage.setFlag(false);
                errorMessage.setMessage("用户名已存在");
            }

        }
        ObjectMapper objectMapper = new ObjectMapper();
        String msg = objectMapper.writeValueAsString(errorMessage);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(msg);
    }
    public void active(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
            String uuid = request.getParameter("activeCode");
            UserServiceImpl userService = new UserServiceImpl();
            if(uuid!=null&&uuid!=""){
                userService.activUser(uuid);
                response.getWriter().print("激活完成<a href='http://127.0.0.1/travel/login.html'>点击跳转登录</a>");


            }else {response.getWriter().print("<h1>激活失败，请联系管理员!</h1>");}
    }
    public void login(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
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
            User user= userService.login(request.getParameter("username"), request.getParameter("password"));
            if(user!=null&&user.getStatus().equalsIgnoreCase("y")){


                msg.setMessage(request.getParameter("username"));
                msg.setFlag(true);
                request.getSession().setAttribute("User",user);
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
    public void findone(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        User user =(User) request.getSession().getAttribute("User");
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String msg_json = objectMapper.writeValueAsString(user);
        response.getWriter().write(msg_json);

    }
}
