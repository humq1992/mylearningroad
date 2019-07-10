package cn.itheima.web.servelet;

import cn.itheima.web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class downloadservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //通过网页传来的请求用getParameter 获得传入的 filename="filename" 中的值。
        String filename = request.getParameter("filename");
        //通过requeset.getServletContext();方法来获得 SERVLETcontext对象。
        ServletContext context =request.getServletContext();
        //通过创建的对象获得物理的存储真实路径
        String realPath = context.getRealPath("/img/"+filename);
        FileInputStream fis=new FileInputStream(realPath);

        //通过创建的对象获得MimeType用来设置响应头
        String mimeType = context.getMimeType(filename);
        //设置响应头 中的  content-type
        response.setHeader("content-type",mimeType);
        //通过响应头中的浏览器信息 传入工具类DownLoadUtils获得支持中文编码的文件名字符串
        String agent = request.getHeader("user-agent");
        String fileName = DownLoadUtils.getFileName(agent, filename);
        //设置响应头 为附件下载格式  拼接字符串确定文件名
        response.setHeader("content-disposition","attachment;filename="+fileName);

        ServletOutputStream os = response.getOutputStream();
        byte[] b=new byte[1024];
        int len=0;
        while ((len=fis.read(b))!=-1){
            os.write(b,0,len);
        }
        fis.close();




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request, response);
    }
}
