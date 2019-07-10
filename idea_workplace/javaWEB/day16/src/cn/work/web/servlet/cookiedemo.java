package cn.work.web.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookiedemo")
public class cookiedemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        Cookie c=null;
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("lasttime")){
                c=cookie;
            }
        }

        if(c==null){
           Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = sdf.format(d);
            String s1 = URLEncoder.encode(s, "utf-8");
            c=new Cookie("lasttime",s1);
            c.setMaxAge(60*60*24*30);
            response.addCookie(c);
            response.getWriter().write("欢迎来访"+ URLDecoder.decode(s1));
        }else{
            response.getWriter().write("你上次登陆时间为："+ URLDecoder.decode(c.getValue()));
            Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = sdf.format(d);
            String s1 = URLEncoder.encode(s, "utf-8");
            c=new Cookie("lasttime",s1);
            c.setMaxAge(60*60*24*30);
            response.addCookie(c);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
