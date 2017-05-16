<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/5/16
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table {
            border-collapse: collapse;
            border: 1px solid #000000;
        }

        td {
            border: 1px solid #000000;
            padding: 2px;
        }

        .title td {
            text-align: center;
            background: #DDDDDD;
        }
        textarea {
            width: 400px;
            height: 50px;
        }
    </style>
</head>
<body>
<form method="get" action="${pageContext.request.requestURL}">
    <textarea name="sql">${param.sql}</textarea>
    <input type="submit"/>
</form>

<sql:setDataSource driver="com.mysql.jdbc.Driver" user="root"
password="12345678"
url="jdbc:mysql://localhost:3306/customer?charachterEncoding=UTF-8"
var="dataSource"/>

<c:catch var="e">
    <sql:query var="rs" dataSource="${dataSource}">
        ${param.sql}
    </sql:query>
<table>
    <tr class="title">
        <c:forEach var="columnName" items="${rs.columnNames}">
            <td>${columnName}</td>
        </c:forEach>
    </tr>

    <c:forEach var="row" items="${rs.rows}">
        <tr>
            <c:forEach var="columnName" items="${rs.columnNames}">
                <td>${row[columnName]}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</c:catch>

<c:if test="${e != null}">
    <div style="color: #f00;">Exception: ${e.message}</div>
</c:if>
</body>
</html>
