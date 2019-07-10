package cn.corp.web.servlet;

import cn.corp.ProvinceService.ProvinceService;
import cn.corp.ProvinceService.ProvinceServiceImpl.ProvinceServiceImpl;

import java.io.IOException;

@javax.servlet.annotation.WebServlet("/ProvinceServlet")
public class ProvinceServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        ProvinceService provinceService = new ProvinceServiceImpl();
        String s = provinceService.findall();
        response.getWriter().write(s);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
