package cn.corp.web.servlet;

import cn.corp.web.domain.Member;
import cn.corp.web.memberService.memberService;
import cn.corp.web.memberService.memberServiceImpl.memberServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/memberServlet")
public class MemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        memberService memberService = new memberServiceImpl();
        List<Member> list = memberService.findall();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(list);
        PrintWriter out = response.getWriter();
        System.out.println(s);
        out.print(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
