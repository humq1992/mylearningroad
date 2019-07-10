<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
</body>
<a href="/user/findAll">查找所有</a>
<br>
<form action="/user/addUser">
    <input type="text" name="name">
    <input type="text" name="age">
    <input type="submit" value="添加一个账户">

</form>
</html>
