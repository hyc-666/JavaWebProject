<%--
  Created by IntelliJ IDEA.
  User: 胡玉琛
  Date: 2020/7/19
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="http://localhost:8080/file/uploadServlet" enctype="multipart/form-data">

    用户名:<input type="text" name="username"><br>
    选择文件:<input type="file" name="photo"><br>
    上传<input type="submit"><br>
  </form>
  </body>
</html>
