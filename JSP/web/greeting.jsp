<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/2/24
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Locale locale = request.getLocale();
    Calendar calendar = Calendar.getInstance(locale);
    int hour = calendar.get(Calendar.HOUR_OF_DAY);

    String greeting = "";
    if (hour <= 6) {
        greeting = "凌晨好，您该睡觉了。";
    }
    else if (hour <= 9) {
        greeting = "早上好。早餐应该注意营养。";
    }
    else if (hour <= 12) {
        greeting = "中午好。工作注意保护眼睛。";
    }
    else if (hour <= 15) {
        greeting = "下午好。小心工作中打瞌睡。";
    }
    else if (hour <= 23) {
        greeting = "晚上好。放松一下自己，好好休息。睡觉不要太晚哦~~";
    }
    else {

    }
%>
<html>
<head>
    <title>欢迎页面</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
  <table>
      <tr>
          <td><%= greeting %></td>
      </tr>
  </table>
</body>
</html>
