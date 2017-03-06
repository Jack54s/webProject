<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/6
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="login.jsp" %>

<%
    request.setCharacterEncoding("UTF-8");

    String username = "";
    int visitTimes = 0;

    Cookie[] cookies = request.getCookies();
    for (int i=0; cookies!=null && i<cookies.length; i++) {
        Cookie cookie = cookies[i];
        if("username".equals(cookie.getName())) {
            username = cookie.getValue();
        }
        else if("visitTimes".equals(cookie.getName())) {
            visitTimes = Integer.parseInt(cookie.getValue());
        }
    }
    if(username == null || username.trim().equals("")) {
        throw new Exception("您还没有登录。请先登录");
    }

    Cookie visitTimesCookie = new Cookie("visitTimes", Integer.toString(++visitTimes));
    response.addCookie(visitTimesCookie);
%>
<html>
<head>
    <title>cookie</title>
</head>
<body>
<div align="center" style="margin: 10px;">
    <fieldset>
        <legend>登录信息</legend>
        <form action="login.jsp" method="post">
            <table>
                <tr>
                    <td>您的账号：</td>
                    <td><%= username %></td>
                </tr>
                <tr>
                    <td>登录次数：</td>
                    <td><%= visitTimes %></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="button" value=" 刷 新 " onclick="location='<%= request.getRequestURI() %>?ts=' + new Date().getTime();" class="button">
                    </td>
                </tr>
            </table>
        </form>
    </fieldset>
</div>
</body>
</html>
