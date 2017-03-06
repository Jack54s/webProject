<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/6
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>计数器</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<br/>
<jsp:useBean id="personCount" class="com.redweb.jsp.bean.Counter" scope="session"/>

<jsp:useBean id="totalCount" class="com.redweb.jsp.bean.Counter" scope="application"/>

<div align="center">
    <form action="" method="get">
        <fieldset style="width: 300px;">
            <legend>计数器</legend>
            <table align="center" width="400">
                <tr>
                    <td width="150" align="right" style="font-weight: bold;">您的访问次数：</td>
                    <td><jsp:getProperty name="personCount" property="count"/>次</td>
                </tr>
                <tr>
                    <td width="150" align="right" style="font-weight: bold;">总共的访问次数：</td>
                    <td>
                        <jsp:getProperty name="totalCount" property="count"/>次
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>

</body>
</html>
