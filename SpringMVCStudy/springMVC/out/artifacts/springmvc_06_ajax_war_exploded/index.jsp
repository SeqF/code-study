<%--
  Created by IntelliJ IDEA.
  User: 50547
  Date: 2020/4/30
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.0.js"></script>

    <script>
      function a(){
        $.post({
          url:"${pageContext.request.contextPath}/a1",
          /*通过ajax来提交username给controller,这个name与controller的name对应*/
          data:{"name":$("#username").val()},
          success:function (data) {
            alert(data);
          },
          error:function () {

          }
        })
      }
    </script>
  </head>
  <body>
  <%--失去焦点的时候，发起一个请求(携带信息）到后台--%>
<input type="text" id="username" onclick="a()">
  </body>
</html>
