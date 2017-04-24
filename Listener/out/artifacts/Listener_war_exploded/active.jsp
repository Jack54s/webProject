<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/10
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.redweb.listener.PersonInfo" %>
<html>
<head>
    <title>active</title>
</head>
<body>
<%
    PersonInfo personInfo = (PersonInfo)session.getAttribute("personInfo");
    if (personInfo == null) {
        personInfo = new PersonInfo();
        personInfo.setName("redweb");
        session.setAttribute("personInfo", personInfo);
        out.println("PersonInfo对象不存在。已经成功新建。sessionId: " + session.getId());
    }
    else {
        out.println("PersonInfo 对象存在。无须新建。sessionId: " + session.getId());
    }
%>
</body>
</html>
