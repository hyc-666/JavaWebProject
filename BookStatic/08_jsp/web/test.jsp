<%--
  Created by IntelliJ IDEA.
  User: 胡玉琛
  Date: 2020/5/6
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    errorPage="/errorPage.jsp"
%>
<html>
<head>
    <title>测试页面</title>
</head>
<body>
    这是jsp动态测试页面！！
    <%--    <%! %> 声明脚本  --%>
    <%! private int id; %>

    <%-- <%=%> 表达式脚本,表达式结尾不能带分号--%>
    <%= "这是表达式脚本输出的内容 "%>
<%--    代码脚本，可以直接写代码--%>
    <% System.out.println("可以直接写代码");%>
</body>
</html>
