<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/4/26
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
action参数为：<c:out value="${param.action}" default="No parameter 'action' found."></c:out>
</body>
</html>
