<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/5/4
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%--<sql:setDataSource driver="com.mysql.jdbc.Driver" user="root"--%>
                   <%--password="12345678"--%>
                   <%--url="jdbc:mysql://localhost:3306/customer?charachterEncoding=UTF-8"--%>
                   <%--var="dataSource"/>--%>
<sql:setDataSource dataSource="jdbc/customer" var="dataSource"/>
<sql:query var="rs" dataSource="${dataSource}" scope="page">
    select * from t_customer
</sql:query>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr class="title">
        <td>ID</td>
        <td>Name</td>
        <td>gender</td>
        <td>phone</td>
    </tr>
    <c:forEach var="row" items="${rs.rows}">
        <tr>
            <td>${row['id']}</td>
            <td>${row['name']}</td>
            <td>${row['gender']}</td>
            <td>${row['phone']}</td>
        </tr>
    </c:forEach>
    </tr>
</table>
</body>
</html>
