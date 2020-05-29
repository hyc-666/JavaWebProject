<%--
  Created by IntelliJ IDEA.
  User: 胡玉琛
  Date: 2020/5/29
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
    <form action="http://192.168.1.6:8080/javaEE01/addUser" method="post">
        <h3 align="center">添加用户</h3>
        <hr>
        <table align="center" cellspacing="5">
            <tr>
                <td>用户名称：</td>
                <td><input name="username" type="text" value=""/></td>
            </tr>
            <tr>
                <td>用户密码：</td>
                <td><input name="password" type="password"/></td>
            </tr>
            <tr>
                <td><button type="reset">清空</button> </td>
                <td><button type="submit">添加</button> </td>
            </tr>
            <tr>
                <td align="center" colspan="2"><a href="index.jsp">返回首页</a> </td>
            </tr>
        </table>
    </form>
</body>
</html>
