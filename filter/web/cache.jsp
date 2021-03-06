<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/3/9
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cache</title>
    <style type="text/css">
        body {
            font-size: 12px;
        }
        div {
            float: left;
            margin-left: 20px;
        }
        a {
            color: #00f;
        }
    </style>
</head>
<body>
<div id="loginDiv">
    <a href="cache.jsp" onclick="setCookie('username','redweb');">登录</a>
    <a href="cache.jsp" onclick="setCookie('username','Admin');setCookie('role','admin');">登录为管理员</a>
</div>
<div id="adminDiv" style="display: none;">
    <a href="cache.jsp">会员管理</a>
    <a href="cache.jsp">公告管理</a>
</div>
<div id="controlDiv" style="display: none;">
    <a href="cache.jsp">个人设置</a>
    <a href="cache.jsp">修改密码</a>
    <a href="cache.jsp" onclick="setCookie('username','');setCookie('role','');">退出</a>
</div>

<script type="text/javascript">
    function setCookie(name, value){
        document.cookie = name + '=' + value;
    }
    function getCookie(name)
    {
        var search = name + "="
        if(document.cookie.length > 0)
        {
            offset = document.cookie.indexOf(search)
            if(offset != -1)
            {
                offset += search.length
                end = document.cookie.indexOf(";", offset)
                if(end == -1) end = document.cookie.length
                return unescape(document.cookie.substring(offset, end))
            }
            else return ""
        }
    }
    if(getCookie('username')){
        // 已经登录  隐藏登录菜单
        document.getElementById('loginDiv').innerText = '欢迎你, ' + getCookie('username');
        // 显示登录后的操作
        document.getElementById('controlDiv').style.display = 'block';
    }
    if(getCookie('role') == 'admin'){
        // 为管理员 显示管理员操作
        document.getElementById('adminDiv').style.display = 'block';
    }
</script>
</body>
</html>
