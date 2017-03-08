<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/8
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>exception</title>
    <style type="text/css">
        .error {
            font-size: 12px;
            padding: 5px;
            border: 1px solid #FF0000;
            background: url(images/error.gif) 8px 5px no-repeat #FFEEFF;
            padding-left: 30px;
        }
    </style>
</head>
<body>
<div class="error">
    ${ message } <a href="javascript:history.go(-1); ">返回</a>
</div>
</body>
</html>
