<%--
  Created by IntelliJ IDEA.
  User: byj
  Date: 2019/7/3
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function () {
            $("#bt1").click(function () {
               $.ajax({
                   url:"/test/testAjax",
                   contentType:"application/json;charset=utf-8",
                   data:'{"username":"zhangsan","age":"18"}',
                   dataType:"JSON",
                   type:"post",
                   success:function (data) {
                       alert(data);
                       alert(data.username);
                       alert(data.age);
                   }
               })
                
            })

        })
    </script>
</head>
<body>
<form action="/user/fileupload" method="post" enctype="multipart/form-data">
    文件<input type="file" name="upload"/>
        <input type="submit" value="上传文件"/>
</form>
<br>
<a href="/test/testString">点我返回字符串</a>
<br>
<a href="/test/testVoid">点我无返回值</a>
<br>
<a href="/test/testModelAndView">点我测试MAV</a>
<br>
<button id="bt1" >点我发送异步请求</button>
<br>
<form action="/user/fileupload2" method="post" enctype="multipart/form-data">
    跨服务器上传文件<input type="file" name="transupload"/>
    <input type="submit" value="上传文件"/>
</form>

</body>
</html>
