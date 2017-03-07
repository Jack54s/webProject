<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/7
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:directive.page import="com.redweb.sessionWeb.bean.Person"/>
<jsp:directive.page import="java.text.SimpleDateFormat"/>
<jsp:directive.page import="java.text.DateFormat"/>
<jsp:directive.page import="java.util.Date"/>

<%!
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
%>
<%
    response.setCharacterEncoding("UTF-8");

    Person[] persons = {
            new Person("Liu Jinghua", "password1", 34, dateFormat.parse("1982-01-01")),
            new Person("Hello Kitty", "hellokitty", 23, dateFormat.parse("1984-02-25")),
            new Person("Garfield", "garfield_pass", 23, dateFormat.parse("1994-09-12")),
    };

    String message = "";

    if(request.getMethod().equals("POST")) {
        for (Person person : persons) {
            if(person.getName().equalsIgnoreCase(request.getParameter("username")) && person.getPassword().equals(request.getParameter("password"))) {
                session.setAttribute("person", person);
                session.setAttribute("loginTime", new Date());

                response.sendRedirect(request.getContextPath() + "/welcome.jsp");
                return;
            }
        }
        message = "用户名密码不匹配，登录失败。";
    }
%>

<html>
<head>
    <title>请先登录</title>
</head>
<body>
<div align="center" style="margin:10px; ">
    <fieldset>
        <legend>登录</legend>
        <form action="session.jsp" method="post">
            <table>
                <% if( ! message.equals("")){ %>
                <tr>
                    <td>
                    </td>
                    <td>
                        <span><img src="images/errorstate.gif"></span>
                        <span style="color:red; "><%= message %></span>
                    </td>
                </tr>
                <% } %>
                <tr>
                    <td>
                        帐号：
                    </td>
                    <td>
                        <input type="text" name="username" style="width:200px; ">
                    </td>
                </tr>
                <tr>
                    <td>
                        密码：
                    </td>
                    <td>
                        <input type="password" name="password" style="width:200px; ">
                    </td>
                </tr>
                <tr>
                    <td>
                    </td>
                    <td>
                        <input type="submit" value=" 登  录 " class="button">
                    </td>
                </tr>
            </table>
        </form>
    </fieldset>
</div>
</body>
</html>
