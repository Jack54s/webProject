<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/5/18
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="taglib" uri="http://www.redweb.com/tags"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<taglib:hello name="Jack" /> <br/>
<taglib:hello name="${pageContext.request.remoteAddr}" /> <br/>
<taglib:hello name="${cookie}" /> <br/>
<taglib:add num1="1" num2="1" /> <br/>
</body>
</html>
