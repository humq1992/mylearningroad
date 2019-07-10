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

@WebServlet("/findServlet")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
