package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.service.impl.CategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/CategoryServlet/*")
public class CategoryServlet extends BaseServlet {
    public void findall(HttpServletRequest request,HttpServletResponse response) throws IOException {
        CategoryService categoryService = new CategoryServiceImpl();
        String findall = categoryService.findall();
        if(findall!=null&&findall!=""){
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(findall);
        }



    }
}
