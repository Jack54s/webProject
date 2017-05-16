<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/5/4
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    request.setAttribute("files", new File("c:\\").listFiles());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr class="title">
        <td>File Name</td>
        <td>Type</td>
    </tr>
    <c:forEach var="file" items="${files}">
        <tr>
            <td>${file.name}</td>
            <td>
                <c:choose>
                    <c:when test="${file.directory}">文件夹</c:when>
                    <c:otherwise>
                        <c:if test="${fn:endsWith(file.name, '.jpg')}">JPG图片</c:if>
                        <c:if test="${fn:endsWith(file.name, '.exe')}">EXE应用程序</c:if>
                        <c:if test="${fn:endsWith(file.name, '.gif')}">GIF图片</c:if>
                        <c:if test="${fn:endsWith(file.name, '.txt')}">TXT文本文件</c:if>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
