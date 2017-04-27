<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/4/27
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:catch var="e">
    <c:set target="someBean" property="someProperty" value="Some Value">
    </c:set>
</c:catch>
<c:if test="${e != null}">
    程序抛出了异常${e["class"].name}，原因：${e.message}
</c:if>
</body>
</html>
