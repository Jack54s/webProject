<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:directive.page import="java.util.Date"/>
<jsp:directive.page import="java.text.SimpleDateFormat"/>
<%
    Date date = (Date)request.getAttribute("date");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
    <TITLE>Forward 跳转</TITLE>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css">
</HEAD>
<BODY>
  <div align="center"><br/>
    <fieldset style="width: 90%"><legend>Forward 跳转</legend><br/>
      <div>
        <div>从ForwardServlet中取到的Date为</div>
        <div><%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(date)%></div>
      </div><br/>
        <div>
          <div align="center">
            <input type='button' onclick='location="<%= request.getContextPath() %>/Forward?destination=servlet";' value="跳转到Servlet" class="button">
            <input type='button' onclick='location="<%= request.getContextPath() %>/Forward?destination=file";' value="跳转到web.xml" class="button">
            <input type='button' onclick='location="<%= request.getContextPath() %>/Forward?destination=jsp";' value="跳转到JSP" class="button">
          </div>
        </div>
    </fieldset>
  </div>
</BODY>
</HTML>