package it.bob.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkcodeservlet")
public class checkcodeservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("praga","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setHeader("expires","0");
        int width=80;
        int height=35;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0,0,width,height);
        String base="0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        Random r=new Random();
        StringBuilder sb = new StringBuilder();
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        for (int i = 0; i < 5; i++) {
            int rn = r.nextInt(base.length());
            sb.append(base.charAt(rn));
            g.drawString(base.charAt(rn)+"",15*i,18);
        }
        String code=sb.toString();
        request.getSession().setAttribute("servecode",code);
        for (int i = 0; i < 10; i++) {
            int x1 = r.nextInt(width);
            int x2 = r.nextInt(width);

            int y1 = r.nextInt(height);
            int y2 = r.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        ImageIO.write(image,"PNG",response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
