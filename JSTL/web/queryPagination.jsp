<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/5/4
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import="com.redweb.util.Pagination"%>
<%@ page import="com.redweb.jstl.bean.Person"%>
<%
    request.setAttribute("pagination", new Pagination(request, response));
%>
<sql:setDataSource driver="com.mysql.jdbc.Driver" user="root"
                   password="12345678"
                   url="jdbc:mysql://localhost:3306/customer?charachterEncoding=UTF-8"
                   var="dataSource"/>
<sql:query var="rs" dataSource="${dataSource}">
    select count(*) count from t_customer
</sql:query>

<c:forEach var="row" items="${rs.rows}">
    <jsp:setProperty name="pagination" property="recordCount" value="${row.count}"/>
</c:forEach>

<sql:query var="rs" dataSource="${dataSource}" startRow="${pagination.firstResult}"
           maxRows="${pagination.pageSize}">
    select * from t_customer
</sql:query>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr class="title">
        <td>help_id</td>
        <td>name</td>
        <td>description</td>
    </tr>
    <c:forEach var="row" items="${rs.rows}">
        <tr>
            <td align="center">${row['id']}</td>
            <td>${row['name']}</td>
            <td>${row['gender']}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<%
    String a = request.getParameter("pagination");
    System.out.println(a);
%>
${pagination}
</body>
</html>
