<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/10
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:directive.page import="com.redweb.util.ApplicationConstants" />
<jsp:directive.page import="java.util.Date" />
<jsp:directive.page import="java.text.DateFormat" />

<%
    String action = request.getParameter("action");
    String name = request.getParameter("name");
    String value = request.getParameter("value");

    session.getId();

    if ("addRequestAttribute".equals(action)) {
        request.setAttribute(name, value);
    }
    else if ("removeRequestAttribute".equals(action)) {
        request.removeAttribute(name);
    }
    else if ("addSessionAttribute".equals(action)) {
        session.setAttribute(name, value);
    }
    else if ("removeSessionAttribute".equals(action)) {
        session.removeAttribute(name);
    }
    else if ("logout".equals(action)) {
        session.invalidate();
        out.println("<a href=listener.jsp>返回</a>");
        return;
    }
%>
<style>
    body, td {
        font-size: 12px;
    }
</style>
<html>
<head>
    <title>listener</title>
</head>
<body>

</body>
</html>
