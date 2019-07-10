<%--
  Created by IntelliJ IDEA.
  User: byj
  Date: 2019/7/4
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>执行成功</h2>
<c:forEach items="${list}" var="user">
${user.name}:${user.age}
</c:forEach>


</body>
</html>
