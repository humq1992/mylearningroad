package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.impl.RouteServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import sun.jvm.hotspot.debugger.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    RouteServiceImpl routeService = new RouteServiceImpl();
    public void findroute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        int _rid = Integer.parseInt(rid);

        Route route = routeService.routedetails(_rid);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(route);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(s);

    }
    public void isfavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("User");
        if(user==null){
            return;
        }else {
            int uid = user.getUid();
            int _rid = Integer.parseInt(rid);
            Favorite favorite = routeService.isfavorite(_rid, uid);
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(favorite);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(s);

        }

    }
    public void addfavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("User");
        int uid = user.getUid();
        int _rid = Integer.parseInt(rid);
        routeService.addfavorite(_rid, new Date(), uid);

    }
    public void rankbyfavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String rname = request.getParameter("rname");
        String minprice = request.getParameter("minprice");
        String maxprice = request.getParameter("maxprice");
        String currentpage = request.getParameter("currentpage");
        String pagesize = request.getParameter("pagesize");
        if(currentpage==null){
            currentpage="1";
        }
        if(pagesize==null){
            pagesize="8";
        }
        if(maxprice==""){
            maxprice=null;
        }
        if(minprice==""){
            minprice=null;
        }
        int _currentpage = Integer.parseInt(currentpage);
        int _pagesize = Integer.parseInt(pagesize);

//获的pb对象
        PageBean pb=routeService.getrankbyfavorite(rname,minprice,maxprice,_currentpage,_pagesize);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pb);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }


}
