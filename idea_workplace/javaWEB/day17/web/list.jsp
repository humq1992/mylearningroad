<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        window.onload = function () {
            document.getElementById("deleteselected").onclick = function () {
                var ids = document.getElementsByName("id");
                var flag = false;
                if (confirm("确定删除")) {
                    for (i = 0; i < ids.length; i++) {
                        if (ids[i].checked) {
                            flag = true;
                        }
                    }
                    if (flag) {
                        document.getElementById("form").submit();

                    } else {
                        alert("选择一项");
                    }
                }


            }


        }
        document.getElementById("fircb").onclick = function () {
            var uids = document.getElementsByName("id");
            for (var i = 0; i < uids.length; i++) {
                uids[i].checked = this.checked;
            }
        }
        function findbypage(currentpage) {
            document.getElementById("currentpage").value=currentpage;
            document.getElementById("form1").submit();
        }



    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="margin: 5px;float: right"><a class="btn btn-primary" href="add.jsp">增加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="deleteselected">删除选中</a></div>
    <div style="float: left">
        <form id="form1" class="form-inline" action="${pageContext.request.contextPath}/findByPageServlet" method="post">
            <input type="hidden" name="currentpage" id="currentpage" >
            <input type="hidden" name="rows"  id="rows" value="5">
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" name="name" value="${user.name}" class="form-control" id="name" >
            </div>
            <div class="form-group">
                <label for="address">籍贯</label>
                <input type="text" name="address" value="${user.address}" class="form-control" id="address" >
            </div>

            <div class="form-group">
                <label for="emil">邮箱</label>
                <input type="text" name="emil" value="${user.emil}" class="form-control" id="emil"  >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <form id="form" method="post" action="${pageContext.request.contextPath}/deleteselectedServlet">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="fircb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${pb.list}" var="user" varStatus="index">
                <tr>
                    <td><input type="checkbox" name="id" value="${user.id}"></td>
                    <td>${index.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.emil}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/updateServlet?uid=${user.id}">修改</a>
                        &nbsp;<a class="btn btn-default btn-sm"
                                 href="${pageContext.request.contextPath}/deleteServlet?uid=${user.id}">删除</a></td>
                </tr>
            </c:forEach>

        </table>

    </form>
    </form>
    <div>
        <nav>
            <ul class="pagination">
                <c:if test="${pb.currentpage>1}">
                <li>
                    <a href="javascript:findbypage(${pb.currentpage-1})" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                </c:if>
                <c:forEach var="i" begin="1" end="${pb.totalpage}" >
                    <c:if test="${pb.currentpage==i}">

                    <li class="active"><a  href="javascript:findbypage(${i})">${i}</a></li>
                    </c:if>
                    <c:if test="${pb.currentpage!=i}">
                        <li><a href="javascript:findbypage(${i})">${i}</a></li>
                    </c:if>

                </c:forEach>
                <c:if test="${pb.currentpage<pb.totalpage}">
                <li>

                    <a href="javascript:findbypage(${pb.currentpage+1})" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>

                </li>
                </c:if>
                <span style="font-size: 20px">总计条${pb.count}记录，共${pb.totalpage}页</span>

            </ul>
        </nav>


    </div>
</div>
</body>
</html>