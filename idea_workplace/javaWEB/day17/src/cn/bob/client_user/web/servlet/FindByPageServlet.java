package cn.bob.client_user.web.servlet;

import cn.bob.client_user.Service.UserService;
import cn.bob.client_user.Service.UserServiceImpl.UserServiceImpl;
import cn.bob.client_user.domain.User;
import cn.bob.client_user.domain.pageBean;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/findByPageServlet")
public class FindByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String _currentpage = request.getParameter("currentpage");//获得当前页面
        if(_currentpage==null||_currentpage.equals("")){
            _currentpage="1";
        }
        int currentpage = Integer.parseInt(_currentpage);
        String _rows = request.getParameter("rows");//获得每页显示数目
        if(_rows==null||_rows.equals("")){
            _rows="5";
        }
        int rows = Integer.parseInt(_rows);
        UserService userService=new UserServiceImpl();
        Map<String, String[]> parameterMap = request.getParameterMap();//通过工具封装查询框提交上来的三个请求参数
        User u = new User();
        try {
            BeanUtils.populate(u,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int count=userService.getcount(u);//获得总结果数目
        List<User> list=userService.findbypage(currentpage,rows,u);//获得展示的list集合
        int totalpage=count/rows==0?count/rows:count/rows+1;//获得总页面数目
        pageBean pagebean = new pageBean();
        pagebean.setCount(count);
        pagebean.setCurrentpage(currentpage);
        pagebean.setList(list);
        pagebean.setRows(rows);
        pagebean.setTotalpage(totalpage);
        request.setAttribute("user",u);
        request.setAttribute("pb",pagebean);
        request.getRequestDispatcher("/list.jsp").forward(request,response);//回传Beans来展示页面数据

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
