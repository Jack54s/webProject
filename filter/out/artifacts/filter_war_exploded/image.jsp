<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/8
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>image</title>
</head>
<body>
<img width="200" src="images/winter.jpg">
<a href="${ pageContext.request.requestURI }">刷新</a>
<%--<a href="javascript:window.open('images/winter.jpg');"
   onclick="window.open('images/winter.jpg'); return false; ">直接访问</a>--%>
<a href="images/winter.jpg">直接访问</a>
<hr/>

request.getHeader("referer"): ${ header['referer'] }
</body>
</html>
