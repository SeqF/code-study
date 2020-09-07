<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 50547
  Date: 2020/4/30
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示</title>

    <%--Bootstrap展示页面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row clearix">
        <div class="col-md-12 column"></div>
        <div class="page-header">
            <h1>
                <small>新增书籍</small>
            </h1>
        </div>

        <form action="${pageContext.request.contextPath}/book/addBook" method="post">
            书籍名称：<input type="text" name="bookName"><br><br><br>
            书籍数量：<input type="text" name="bookCounts"><br><br><br>
            书籍详情：<input type="text" name="detail"><br><br><br>
            <input type="submit" value="添加">
        </form>



</div>
</body>
</html>
