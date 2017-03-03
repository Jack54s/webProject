<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/3
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>break</title>
</head>
<body>
<%
    for (int i=0; i<5; i++) {
        %>  break所在的循环，i = <%= i %>.<br/>
<%
        if(i == 2) break;
    }
%>  break循环完毕.<br/>
<%
    for (int i=0; i<5; i++) {
        %>  return所在的循环，i = <%= i %>.<br/>
<%
        if(i == 2) return;
    }
%>  return 循环完毕.<br/>
</body>
</html>
