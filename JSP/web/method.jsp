<%--
  Created by IntelliJ IDEA.
  User: 11407
  Date: 2017/2/24
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! //注意是%!
    private IPSeeker ipSeeker = IPSeeker.getInstance();

    public String getArea(String ip) {
        return ipSeeker.getArea(ip);
    }

    public String getCountry(String ip) {
        return ipSeeker.getCountry(ip);
    }

    public boolean isValidIp(String ip) {
        return ip != null && ip.trim().matches("^[0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+$");
    }
%>
<html>
<head>
    <title>IP地址查询</title>
</head>
<body>

</body>
</html>
