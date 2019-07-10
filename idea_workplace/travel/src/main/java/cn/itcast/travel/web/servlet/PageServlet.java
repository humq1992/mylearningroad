package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.service.impl.CategoryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page/*")
public class PageServlet extends BaseServlet {
    public void findbypage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentpage = request.getParameter("currentpage");//获得页面当前页码
        String cid = request.getParameter("cid");//获得当前页面分类uid
        String pagesize = request.getParameter("pagesize");//获得当前页面展示数目
        String rname = request.getParameter("rname");
        if(currentpage==null||currentpage==""){
            currentpage="1";
        }
        if(cid==null){
            cid="1";
        }
        if(pagesize==null){
            pagesize="10";
        }
        if(rname==null){
            rname="";
        }
        int cid_int = Integer.parseInt(cid);
        int currentpage_int = Integer.parseInt(currentpage);
        int pagesize_int = Integer.parseInt(pagesize);
        CategoryService categoryService = new CategoryServiceImpl();
        PageBean pb = categoryService.findbypage(cid_int, currentpage_int, pagesize_int,rname);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String pb_json = objectMapper.writeValueAsString(pb);
        response.getWriter().write(pb_json);

    }


}
