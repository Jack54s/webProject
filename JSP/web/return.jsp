<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/3
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>return</title>
</head>
<body>
<%
    String param = request.getParameter("param");
%>
昔我往矣，<br/>
杨柳依依。<br/>
今我来思，<br/>
雨雪霏霏。<br/>
<%
    if("return".equals(param)) {
        return;
    }
%>
青青子衿，<br/>
悠悠我心。<br/>
但为君故，<br/>
沉吟至今。<br/>

<a href="<%= request.getRequestURI() %>?param=return"><%= request.getRequestURI() %>?param=return</a>
</body>
</html>
