<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/6
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:directive.page import="sun.misc.BASE64Decoder"/>
<jsp:directive.page import="java.net.URLDecoder"/>
<%@ page trimDirectiveWhitespaces="true"%>
<%
    out.clear();
    for(Cookie cookie : request.getCookies()) {
        if(cookie.getName().equals("file")) {
            String value = URLDecoder.decode(cookie.getValue(), "UTF-8");
            byte[] binary = BASE64Decoder.class.newInstance().decodeBuffer(value.replace(" ", ""));

            response.setHeader("Content-Type", "image/gif");
            response.setHeader("Content-Disposition", "inline; filename=cookie.gif");
            response.setHeader("Connection", "close");
            response.setContentLength(binary.length);
            response.getOutputStream().write(binary);
            response.getOutputStream().flush();
            response.getOutputStream().close();
            return;
        }
    }
%>
