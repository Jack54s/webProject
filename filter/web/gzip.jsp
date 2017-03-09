<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/9
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLConnection" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.text.NumberFormat" %>

<html>
<head>
    <title>gzip</title>
    <style type="text/css">
        body {
            margin-top: 2px;
        }
        table {
            margin-top: 10px;
            border-collapse: collapse;
            border: 1px solid #000;
            width: 350px;
        }
        td {
            border: 1px solid #000;
            font-size: 12px;
            padding: 2px;
            background: #ddf;
        }
    </style>
</head>
<body>
<%!
    public void test(JspWriter out, String url) throws Exception {
        URLConnection connGzip = new URL(url).openConnection();
        connGzip.setRequestProperty("Accept-Encoding", "gzip");
        int lengthGzip = connGzip.getContentLength();

        URLConnection connCommon = new URL(url).openConnection();
        int lengthCommon = connCommon.getContentLength();

        double rate = new Double(lengthGzip) / lengthCommon;

        out.println("<table>");
        out.println("	<tr>");
        out.println("		<td colspan=3>网址: " + url + "</td>");
        out.println("	</tr>");
        out.println("	<tr>");
        out.println("		<td>压缩后:" + lengthGzip + " byte</td>");
        out.println("		<td>压缩前:" + lengthCommon + " byte</td>");
        out.println("		<td>比率:" + NumberFormat.getPercentInstance().format(rate) + "</td>");
        out.println("	</tr>");
        out.println("</table>");
    }
%>
<%
    String[] urls = {
            "http://localhost:8080/image.jsp",
            "http://localhost:8080/winter.jpg",
            "http://www.baidu.com",
            "http://www.google.cn",
    };
    for(String url : urls){
        test(out, url);
    }
%>
</body>
</html>
