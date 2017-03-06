<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/6
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>JSP ERROR</title>
</head>
<body>
<%
    out.println("程序抛出了一个异常：" + exception);
%>
</body>
</html>
