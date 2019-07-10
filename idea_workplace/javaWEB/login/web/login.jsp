<%--
  Created by IntelliJ IDEA.
  User: byj
  Date: 2019/6/1
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script>
      window.onload=function () {
          document.getElementById("codec").onclick=function () {

              var date = new Date();
              this.src="/login/checkcodeservlet?time="+date.getTime()
          }
      }
    </script>
  </head>
  <body>
  <form action="loginservlet" method="post">
  用户名<input type="text" name="username">
  密码<input type="password" name="password">
    <div><%=request.getAttribute("up_error") == null ? "" : request.getAttribute("up_error") %></div>
  验证码<input type="text" name="checkcode">
    <div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div>
  <img src="/login/checkcodeservlet" id="codec">
  <input type="submit" value="登陆">
  </form>


  </body>
</html>
