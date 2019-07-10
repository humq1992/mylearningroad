<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
      $(function () {
          $.get("ProvinceServlet",function (data) {
              for(var i=0;i<data.length;i++){
                  $("#se1").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>")
              }
          })

      })
    </script>
  </head>
  <body>
  <select id="se1" name="province" >
    <option>--请选择--</option>

  </select>
  </body>
</html>
