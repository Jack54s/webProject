<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/3
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>诗经</title>
</head>
<body>
<%
    String param = request.getParameter("param");
    if("1".equals(param)) {
    %>
    昔我往矣，杨柳依依。<br/>
    今我来思，雨雪霏霏。<br/>
    <%
    }
    else if("2".equals(param)) {
    %>
    茕茕白兔，东奔西顾。<br/>
    衣不如新，人不如故。<br/>
    <%
    }
    else if("3".equals(param)) {
    %>
    青青子衿，悠悠我心。<br/>
    纵我不往，子宁不嗣音。<br/>
    <%
    }
    else {
    %>
    请使用参数param=1, 2, 3选择要显示的诗歌
    <%
    }
%>
</body>
</html>
