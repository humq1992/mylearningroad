package cn.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(value="/shit")
public class demo01 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String crime = req.getParameter("crime");
        PrintWriter respWriter = resp.getWriter();
        respWriter.print("<tabel><tr><td>"+name+"</td><td>"+crime+"</td></tr></table>");
        req.setAttribute("msg","nihao");
        req.getRequestDispatcher("/demo02").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String crime = req.getParameter("crime");
        PrintWriter respWriter = resp.getWriter();
        respWriter.write("<table style='border:1px solid red'><tr><td>"+name+"</td><td>"+crime+"</td></tr></table>");
    }
}
