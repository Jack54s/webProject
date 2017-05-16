<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/5/16
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:setDataSource driver="com.mysql.jdbc.Driver"
                   user="root"
                   password="12345678"
                   url="jdbc:mysql://localhost:3306/customer?charachterEncoding=UTF-8"
                   var="dataSource"/>

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
    </style>
</head>
<body>
<sql:update var="result" dataSource="${dataSource}">
    update t_customer set name='jack' where name='fa'
</sql:update>
Update Table 影响到的数据条数：${result} <br/>

<sql:update var="result" dataSource="${dataSource}">
    create table tb_corporation (
    id integer auto_increment,
    name varchar(255),
    description text,
    primary key(id)
    )
</sql:update>

Create Table 影响到的数据条数：${result} <br/>

<sql:update var="result" dataSource="${dataSource}">
    insert into tb_corporation (name, description) values ('MicroSoft', '微软')
</sql:update>

Insert 影响到的数据条数：${result} <br/>

<sql:update var="result" dataSource="${dataSource}">
    drop table  if exists tb_corporation
</sql:update>

Drop Table 影响到的数据条数：${result}
</body>
</html>
