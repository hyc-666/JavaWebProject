<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 胡玉琛
  Date: 2020/5/18
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业4</title>
    <base href="http://192.168.1.6:8080/JavaEE/">
</head>
<body>

<%--   1、 编写一个JSP页面，获取浏览器客户端的类型、IP地址。--%>
    <%-- 获得浏览器客户端类型--%>
    <br/>
    1、 编写一个JSP页面，获取浏览器客户端的类型、IP地址。<br/>
    <%=request.getHeader("User-Agent")%><br/>
    <%-- 字段说明:
        request.getHeader("User-Agent")可以获得请求的信息，其中User-Agent字段中
        不仅包含浏览器类型，还包括客户端操作系统，浏览器版本号等等。。
    --%>
    <%-- 获取客户端IP--%>
    <br/>
    客户端IP=<%=request.getRemoteHost()%><br/>
    <%
        System.out.println(request.getHeader("User-Agent"));
        System.out.println(request.getRemoteHost());
    %>
    <%-- 说明：
        使用localhost访问时，得到的客户端IP是：127.0.0.1
        使用127.0.0.1访问时得到的客户点IP是127.0.0.1
        使用真实IP访问时得到的是真实IP
    --%>

    <%-- 2、编写一个网站访问计数网页，打开该网页显示该网站被访问的次数，
    注意：每个客户第一次访问使计数器增加，后面刷新网站不能使计数器增加。--%>
    <%--  为了能达到此效果，额外定义一个静态变量来记录这个网页被访问的次数，而后还要统计记录每个客户端的信息
      比如我这里记录的是客户端的ip地址，每次被访问时如果该ip已经在我的记录之中
      那么就是重复访问，不使计数器增加，另外，为了快速检索，这里使用hashmap来保存记录--%>
    2、编写一个网站访问计数网页，打开该网页显示该网站被访问的次数，<br/>
    注意：每个客户第一次访问使计数器增加，后面刷新网站不能使计数器增加。<br/>
    <%!
        private static int pageCount = 0;
        private Map<String,Integer> records = new HashMap<>();
        //这里String保存的是客户端IP，Integer保存的是这个IP访问该网页的次数，该IP每访问一次该网页，value就+1
    %>
    <%--  下面的代码处理每个IP访问的过程  --%>
    <%--  暂时先不考虑多线程与并发事件  --%>
    <%
        //每当有请求访问这个页面的时候，首先获得客户端IP信息
        String clientIp = request.getRemoteHost();
        //查看该IP是否已经被记录
        if (records.containsKey(clientIp)){
            //如果该IP已经访问过这个页面就更新该IP访问这个页面的次数
            int value = records.get(clientIp);
            records.put(clientIp,value + 1);
        }else{
            //如果该IP没有访问过这个网页，就使网页计数器自增，并且记录下这个IP
            pageCount++;
            records.put(clientIp,1);
        }
    %>
    <br/>
    该网页被访问的次数=<%=pageCount%><br/>

    <%--3、使用session编写用户登录程序。--%>
    <%--  暂时想到的方法是登陆程序界面写一个表单,然后获取到用户名/账号,密码，验证码等信息，
    然后将这属性存储到session对象中，
      如果需要则可以链接数据库查询用户信息以完成登陆验证--%>
    <%-- 登陆验证的表单--%>
    <br/>
        3、使用session编写用户登录程序。<br/>
    <form method="post">
        <table cellspacing="5">
            <tr>
                <td>用户名：</td>
                <td><input name="username" type="text"><td/>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input name="password" type="password"></td>>
            </tr>
            <tr>
                <td><button type="reset">清除</button> </td>
            <td ><button type="submit">登陆</button></td>
            </tr>
        </table>
    </form>
    <%
        //保存用户信息到session对象
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        session.setAttribute("username",username);
        session.setAttribute("password",password);
//        System.out.println(session.getAttribute("username") + "   " + session.getAttribute("password"));
    %>

    4、简述Servlet的编程过程，使用servlet完成登录验证功能。<br/>
    <a href="userLogin.html">登陆界面</a><br/>

    <a href="http://192.168.1.6:8080/JavaEE/counter">5、定义计数器类Counter（javabean），重新实现第2题。</a>
</body>
</html>
