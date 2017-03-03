<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/3
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Scriptlets</title>
</head>
<body>
<%
    int num = 10;
    int result = 1;
    for(int i=1; i<=num; i++) {
        result *= i;
    }
    out.println("数字 " + num + " 的阶乘为：" + result);
%>
<br/>
<%--数字 <%= num %> 的阶乘为：<%= result %>--%>
</body>
</html>
