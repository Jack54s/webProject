<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/4/27
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    request.setAttribute("somemap", new HashMap());
%>
<c:remove var="somemap"></c:remove>
<html>
<head>
    <title>Title</title>
</head>
<body>
${somemap == null ? "somemap 已经被删除" : "somemap没有被删除"}
</body>
</html>
