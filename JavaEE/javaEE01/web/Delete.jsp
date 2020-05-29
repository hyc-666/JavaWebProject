<%--
  Created by IntelliJ IDEA.
  User: 胡玉琛
  Date: 2020/5/29
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除用户</title>
</head>
<body>
    <br>
    <form action="http://192.168.1.6:8080/javaEE01/delete" method="post">
        <h3 align="center">删除用户</h3>
        <hr/>
        <table align="center" cellspacing="5">
            <tr>
                <td>输入要删除的用户名：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><button type="submit">删除用户</button> </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><a href="index.jsp">返回首页</a> </td>
            </tr>
        </table>
    </form>
</body>
</html>
