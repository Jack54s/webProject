<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/8
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>account登录</title>
    <style type="text/css">
        body, td, div, input {
            font-size: 12px;
        }
        .error {
            padding: 5px;
            border: 1px solid #FF0000;
            background: url(images/error.gif) 8px 5px no-repeat #FFEEFF;
            padding-left: 30px;
        }
    </style>
</head>
<body>
<div class="error">
    ${ message }
</div>

<form action="" method="post">
    <table>
        <tr>
            <td>帐号</td>
            <td><input type="text" name="account" /></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value=" 登录 " /></td>
        </tr>
    </table>
</form>
</body>
</html>
