<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/4/27
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    request.setAttribute("person", new com.redweb.jstl.bean.Person());
    request.setAttribute("map", new java.util.HashMap());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set target="${person}" property="name" value="${param.name}"></c:set>
${person.name}<br/>
<c:set target="${map}" property="name" value="${param.name}"></c:set>
${map.name}<br/>
<c:set var="totalCount" value="${totalCount + 1}" scope="application"></c:set>
<c:set var="count" value="${count + 1}" scope="session"></c:set>
本网站总访问人次：${totalCount}<br/>
其中您的访问次数：${count}<br/>
</body>
</html>
