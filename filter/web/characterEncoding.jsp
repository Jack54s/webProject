<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/8
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>characterEncoding</title>
    <style>
        body, input, textarea {
            font-size: 12px;
        }
        textarea {
            width: 400px;
            height: 50px;
        }
    </style>
</head>
<body>
<pre>
    <b>您输入了</b>
    ${ param.text }
</pre>
<form action="${ param.request.requestURL }" method="post">
    <textarea name="text">${ param.text }</textarea><br/>
    <input type="submit">
</form>
</body>
</html>
