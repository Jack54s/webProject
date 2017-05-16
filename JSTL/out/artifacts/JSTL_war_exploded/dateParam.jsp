<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/5/16
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

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
<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
<sql:setDataSource driver="com.mysql.jdbc.Driver" user="root"
password="12345678"
url="jdbc:mysql://localhost:3306/customer?charachterEncoding=UTF-8"
var="dataSource" scope="page"/>

<sql:update dataSource="${dataSource}">
    create table if not exists tb_person
    (id integer auto_increment,
    name varchar(255),
    birthday timestamp null,
    primary key(id)
    )
</sql:update>

<sql:update dataSource="${dataSource}">
    insert into tb_person(name, birthday) values( ?, ?)
    <sql:param value="Jack"></sql:param>
    <sql:dateParam value="${date}" type="timestamp"/>
</sql:update>

<sql:query var="rs" dataSource="${dataSource}">
    select * from tb_person where birthday > (? - 1)
    <sql:param value="${date}"></sql:param>
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
    <sql:update var="result" dataSource="${dataSource}">
        drop table if exists tb_person
    </sql:update>
    Drop 影响的数据条数：${result}
</table>
</body>
</html>
