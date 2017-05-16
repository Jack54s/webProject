<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/4/28
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:directive.page import="java.util.TimeZone"/>
<jsp:directive.page import="java.util.Map"/>
<jsp:directive.page import="java.util.HashMap"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table, td, tr {font-size: 12px; }
        table {
            border-collapse: collapse;
            border: 1px solid #000000;
        }
        td, th {
            border: 1px solid #000000;
            padding: 2px;
            padding-left: 10px;
            padding-right: 10px;
        }
        .title {
            background: #EEEEEE;
        }
        .title td {
            text-align: center;
        }
    </style>
</head>
<body>
<%
    Map<String, TimeZone> hashMap = new HashMap<String, TimeZone>();

    for(String ID : TimeZone.getAvailableIDs()){
        hashMap.put(ID, TimeZone.getTimeZone(ID));
    }

    request.setAttribute("timeZoneIds", TimeZone.getAvailableIDs());
    request.setAttribute("timeZone", hashMap);
%>

<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>

<fmt:setLocale value="zh_CN" />

现在时刻：<%= TimeZone.getDefault().getDisplayName() %>
<fmt:formatDate value="${ date }" type="both" /> <br/>

<table>
    <tr>
        <th>时区ID</th>
        <th>时区</th>
        <th>现在时间</th>
        <th>时差</th>
    </tr>

    <c:forEach var="ID" items="${ timeZoneIds }" varStatus="status">
        <tr>
            <td>${ ID }</td>
            <td>${ timeZone[ID].displayName }</td>
            <td>
                <fmt:timeZone value="${ ID }" >
                    <fmt:formatDate value="${ date }" type="both" timeZone="${ ID }"/>
                </fmt:timeZone>
            </td>
            <td>${ timeZone[ID].rawOffset / 60 / 60 / 1000 }</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
