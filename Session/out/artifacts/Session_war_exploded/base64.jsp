<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/6
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:directive.page import="sun.misc.BASE64Encoder"/>
<jsp:directive.page import="java.io.InputStream"/>
<jsp:directive.page import="java.io.File"/>
<jsp:directive.page import="java.net.URLEncoder"/>

<%
    File file = new File(config.getServletContext().getRealPath("cookie.gif"));

    byte[] binary = new byte[(int)file.length()];

    InputStream ins = config.getServletContext().getResourceAsStream(file.getName());
    ins.read(binary);
    ins.close();

    String context = BASE64Encoder.class.newInstance().encode(binary);
    Cookie cookie = new Cookie("file", URLEncoder.encode(context, "UTF-8"));
    response.addCookie(cookie);
%>
<html>
<head>
    <title>CookieEncoding</title>
</head>
<body>
从Cookie中获取到的二进制图片：<img src="base64_decode.jsp"/><br/>
<textarea id="cookieArea" style="width: 100%; height: 200px;"></textarea>
<script type="text/javascript">
    cookieArea.value=document.cookie;
</script>
</body>
</html>
