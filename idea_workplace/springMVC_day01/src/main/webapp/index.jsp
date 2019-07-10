<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%--<a href="param/testParam">请求参数绑定</a>--%>

把数据封装Account类中
<form action="param/finduser" method="post">
    姓名：<input type="text" name="uname" /><br/>
    年龄：<input type="text" name="age" /><br/>
    生日：<input type="text" name="birthday" /><br/>

    <input type="submit" value="提交" />
</form>
</body>
</html>
