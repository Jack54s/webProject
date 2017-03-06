<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/6
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:directive.page import="java.net.URLEncoder"/>
<jsp:directive.page import="java.net.URLDecoder"/>

<%
    Cookie cookie = new Cookie(URLEncoder.encode("姓名", "UTF-8"), URLEncoder.encode("刘京华", "UTF-8"));

    response.addCookie(cookie);
%>
<html>
<head>
    <title>Cookie Encoding</title>
</head>
<body>
<%
    if(request.getCookies() != null) {
        for(Cookie cc : request.getCookies()) {
            String cookieName = URLDecoder.decode(cc.getName(), "UTF-8");
            String cookieValue = URLDecoder.decode(cc.getValue(), "UTF-8");

            out.println(cookieName + "=" + cookieValue + "; <br/>");
        }
    }
    else {
        out.println("Cookie 已经写入客户端，请刷新页面。");
    }
%>
</body>
</html>
