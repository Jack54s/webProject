<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/6
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="false" %>

<%
    out.clear();
    if("1".equals(request.getParameter("param"))) {
        %>
<jsp:forward page="/if.jsp">
    <jsp:param name="param" value="1"/>
</jsp:forward>
<%
    }
%>
<html>
<head>
    <title>forward</title>
</head>
<body>
请使用地址栏参数 param=1 访问该页面
</body>
</html>
