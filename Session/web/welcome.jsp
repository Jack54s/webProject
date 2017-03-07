<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/7
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:directive.page import="com.redweb.sessionWeb.bean.Person"/>
<jsp:directive.page import="java.text.SimpleDateFormat"/>
<jsp:directive.page import="java.util.Date"/>
<%@ page import="java.text.DateFormat" %>

<%!
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
%>
<%
    if(session.getAttribute("person") == null) {
        response.sendRedirect("session.jsp");
        return;
    }
%>

<html>
<head>
    <title>欢迎您， ${ person.name }</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div align="center" style="margin:10px; ">
    <fieldset>
        <legend>欢迎您${ person.name }</legend>
        <table>
            <tr>
                <td>
                    您的姓名：
                </td>
                <td>
                    ${ person.name }
                </td>
            </tr>
            <tr>
                <td>
                    登录时间：
                </td>
                <td>
                    ${ loginTime }
                </td>
            </tr>
            <tr>
                <td>
                    您的年龄：
                </td>
                <td>
                    ${ person.age }
                </td>
            </tr>
            <tr>
                <td>
                    您的生日：
                </td>
                <td>
                    ${ person.birthday }
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <input type="button" value=" 重新登录 " onclick="location='session.jsp';" class="button">
                </td>
            </tr>
        </table>
    </fieldset>
</div>
</body>
</html>
