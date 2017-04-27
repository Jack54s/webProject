<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/4/26
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<c:choose>
    <c:when test="${ param.action }">
        when 标签的输出
    </c:when>
    <c:otherwise>
        otherwise 标签的输出
    </c:otherwise>
</c:choose>
</body>
</html>
