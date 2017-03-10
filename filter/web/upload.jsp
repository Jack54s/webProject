<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/10
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.File" %>

<html>
<head>
    <title>upload</title>
    <style type="text/css">
        body {
            font-size: 12px;
        }
    </style>
</head>
<body>
header['Content-type'] = ${ header['Content-type'] }

<form action="" method="post" enctype="multipart/form-data">

    <input type="text" name="text1"> <%= request.getParameter("text1") %> <br/>
    <input type="text" name="text2"> <%= request.getParameter("text2") %> <br/>

    <input type="file" name="file1">
    <%
        File file1 =  (File)request.getAttribute("file1");
        if(file1 != null)
            out.println("<br/>文件: " + file1 + ", <br/>大小: " + file1.length());
    %>  <br/>
    <input type="file" name="file2">
    <%
        File file2 =  (File)request.getAttribute("file2");
        if(file2 != null)
            out.println("<br/>文件: " + file2 + ", <br/>大小: " + file2.length());
    %> <br/>

    <input type="submit" value=" 上传文件 ">

</form>
</body>
</html>
