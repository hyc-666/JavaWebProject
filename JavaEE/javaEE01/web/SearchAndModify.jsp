<%@ page import="javaEE01.service.UserService" %>
<%@ page import="javaEE01.service.impl.UserServiceImpl" %>
<%@ page import="javaEE01.javaBean.User" %><%--
  Created by IntelliJ IDEA.
  User: 胡玉琛
  Date: 2020/5/29
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询和修改用户</title>
</head>
<body>
    <h3 align="center">查询和修改用户</h3>
    <hr/>
    <%--  这个页面有两个功能，本来想把查询的功能直接写在jsp的代码脚本中的
      但是这样并不符合mvc的架构模式，还是写两个servlet程序分别完成业务需求
      --%>
    <%--  同样第一个页面需要与数据库交互，所以应当持有一个userService对象  --%>
    <%!
        private UserService userService = new UserServiceImpl();

    %>
    <form action="http://192.168.1.6:8080/javaEE01/searchAndModify" method="get">
        <table align="center" cellspacing="3">
            <tr>
                <td>输入查询的用户名：</td>
                <td><input name="username" type="text"></td>
                <td><button type="submit">查询用户</button> </td>
            </tr>
        </table>
    </form>
    <%
        String username = request.getParameter("username");
        User user = new User("","");//防止下文user一上来刚开始访问就为null
        //所以可以事先显示这两个默认信息
        User res =  userService.search(username);
        if (res == null) {//如果没找到则提示用户不存在
            out.write("用户不存在");
        }else{
            user = res;
        }
    %>
<%--  第二个功能完成修改  --%>
    <form action="http://192.168.1.6:8080/javaEE01/searchAndModify" method="post">
        <hr>
        <table align="center" cellspacing="10">
            <tr>
                <td>用户名称：</td>
                <td><input name="username" type="text" value="<%=user.getUsername()%>"/></td>
            </tr>
            <tr>
                <td>用户密码：</td>
                <td><input name="password" type="password" value="<%=user.getPassword()%>"/></td>
            </tr>
            <tr>
                <td align="center" colspan="2"><button type="submit">修改用户</button> </td>
            </tr>
        </table>
        <hr/>
        <table align="center">
            <tr>
                <td align="center"><a href="Delete.jsp">删除用户</a></td>
            </tr>
            <tr>
                <td align="center"><a href="AddUser.jsp">添加用户</a></td>
            </tr>
        </table>
    </form>

</body>
</html>
