<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/3
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>while</title>
</head>
<body>
<%
    java.util.List<String> list = new java.util.ArrayList<String>();

    list.add("茕茕白兔");
    list.add("东奔西顾");
    list.add("衣不如新");
    list.add("人不如故");
    java.util.Iterator it = list.iterator();
    while(it.hasNext()) {
        %><%= it.next() %><br/>
<%
    }
%>
</body>
</html>
