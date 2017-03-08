<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/8
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.redweb.exception.BusinessException" %>
<%@ page import="com.redweb.exception.AccountException" %>
<%
    String action = request.getParameter("action");

    if("businessException".equals(action)) {
        throw new BusinessException("业务操作失败。");
    }
    else if("accountException".equals(action)) {
        throw new AccountException("您需要登录后再进行此项操作。");
    }
    else if("exception".equals(action)) {
        Integer.parseInt("");
    }
%>
<html>
<head>
    <title>ExceptionHandle</title>
</head>
<body>
<a href="${ pageContext.request.requestURI }?action=businessException">test BusinessException</a> <br/>
<a href="${ pageContext.request.requestURI }?action=accountException">test AccountException</a> <br/>
<a href="${ pageContext.request.requestURI }?action=exception">test Exception</a> <br/>
</body>
</html>
