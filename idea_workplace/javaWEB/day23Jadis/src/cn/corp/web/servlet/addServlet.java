package cn.corp.web.servlet;

import cn.corp.ProvinceService.ProvinceService;
import cn.corp.ProvinceService.ProvinceServiceImpl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String s = request.getParameter("province");
        ProvinceService provinceService = new ProvinceServiceImpl();
        provinceService.add(s);
        response.sendRedirect(request.getContextPath()+"/index.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
