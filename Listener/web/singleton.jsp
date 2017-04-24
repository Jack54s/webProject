<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/10
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:directive.page import="com.redweb.singleton.PersonInfo" />

<%
    String action = request.getParameter("action");
    String account = request.getParameter("account");

    if("login".equals(action) && account.trim().length() > 0) {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setAccount(account.trim().toLowerCase());
        personInfo.setIp(request.getRemoteAddr());
        personInfo.setLoginDate(new java.util.Date());
        session.setAttribute("personInfo", personInfo);

        response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
        return;
    }
    else if ("logout".equals(action)) {
        session.removeAttribute("personInfo");
        response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
        return;
    }
%>
<html>
<head>
    <title>singleton</title>
</head>
<body>
  <c:choose>
      <c:when test="${personInfo != null}">
        欢迎您，${personInfo.account}。
        您登录的IP是${personInfo.ip}，登录时间为<fmt:formatDate value="${personInfo.loginDate}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate>
        <a href="${pageContext.request.requestURI}?action=logout">退出</a>
        <script>setTimeout("location=location; ", 5000);</script>
      </c:when>
      <c:otherwise>
          ${msg}
          <c:remove var="msg" scope="session"></c:remove>
          <form action="${pageContext.request.requestURI}?action=login" method="post">
              <input name="account">
              <input type="submit" value="登录">
          </form>
      </c:otherwise>
  </c:choose>
</body>
</html>
