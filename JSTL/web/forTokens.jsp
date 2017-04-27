<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/4/27
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr bgcolor="#ccc">
        <td>varStatus.index</td>
        <td>name</td>
    </tr>
    <c:forTokens items="Jane,Tomi,Andy,Hedrix,McCartney,Lenno,Court,Ben" delims="," var="item" varStatus="varStatus" begin="1" end="7" step="2">
    <tr>
        <td>${varStatus.index}</td>
        <td>${item}</td>
    </tr>
    </c:forTokens>
</table>
</body>
</html>
