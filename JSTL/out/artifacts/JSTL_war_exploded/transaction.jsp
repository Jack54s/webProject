<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/5/16
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<sql:setDataSource driver="com.mysql.jdbc.Driver" user="root"
password="12345678"
url="jdbc:mysql://localhost:3306/customer?charachterEncoding=UTF-8"
var="dataSource"/>
<body>
<c:catch var="e">
    <sql:transaction dataSource="${dataSource}">
        <c:forEach var="i" begin="1" end="3">
            <sql:update var="result">
                insert into tb_corporation (name, description) values('test', 'test')
            </sql:update>
            已插入一条。<br/>
        </c:forEach>

        <sql:update var="result">
            insert into tb_corporation (id, name, description ) values (1, 'test', 'test')
        </sql:update>
    </sql:transaction>
</c:catch>

<c:if test="${e != null}">
    <div style="color:red;">操作异常，原因：${e.message}。事务已经回滚。</div>
</c:if>

<sql:query var="rs" dataSource="${dataSource}">
    select * from tb_corporation
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
</body>
</html>
