package it.byj.web.servlet;

import it.byj.web.dao.ProductDao;
import it.byj.web.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/FindAllServlet")
public class FindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        ProductDao productDao = new ProductDao();
        List<Product> list = productDao.findAll();
        out.write("<table style=\"background-color: blanchedalmond;text-align: center;border: 1px solid black;\n" +
                "width: 500px;height: 180px\">");
        for (Product product : list) {
           out.write("<tr>");
           out.write("<td style=\"border:1px solid black\">"+product.getId()+"</td>");
           out.write("<td style=\"border:1px solid black\">"+product.getName()+"</td>");
           out.write("<td style=\"border:1px solid black\">"+product.getPrize()+"</td>");
           out.write("<td style=\"border:1px solid black\">"+product.getNumber()+"</td>");
            out.write("</tr>");
        }
        out.write("</table>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
