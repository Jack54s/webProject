<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/4/28
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

header['User-Agent'] = "${header['User-Agent']}";<br/><br/>

您使用
<c:if test="${fn:contains(header['User-Agent'], 'MSIE')}">IE 浏览器</c:if>
<c:if test="${fn:contains(header['User-Agent'], 'Firefox')}">Firefox 浏览器</c:if>
<c:if test="${fn:contains(header['User-Agent'], 'Maxthon')}">Maxth 浏览器</c:if>
<c:if test="${fn:contains(header['User-Agent'], 'Opera')}">Opera 浏览器</c:if>
<c:if test="${fn:contains(header['User-Agent'], 'TheWorld')}">世界之窗浏览器</c:if>
<c:if test="${fn:contains(header['User-Agent'], 'Kubuntu')}">Kubuntu 浏览器</c:if>
<c:if test="${fn:contains(header['User-Agent'], 'Chrome')}">Chrome 浏览器</c:if>
<br/>
<c:if test="${fn:contains(header['User-Agent'], 'Windows')}">Windows操作系统</c:if>
<c:if test="${fn:contains(header['User-Agent'], 'windows')}">Windows操作系统</c:if>
<c:if test="${fn:contains(header['User-Agent'], 'Linux')}">Linux操作系统</c:if>
</body>
</html>
