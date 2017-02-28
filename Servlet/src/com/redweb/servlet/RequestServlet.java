package com.redweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Locale;

/**
 * Created by 11407 on 2017/2/21.
 */
@WebServlet(name = "RequestServlet", urlPatterns = {"/RequestServlet"})
public class RequestServlet extends HttpServlet {
    private String getAccept(String accept) {
        StringBuffer buffer = new StringBuffer();
        if(accept.contains("image/gif"))  buffer.append("GIF 文件, ");
        if(accept.contains("image/x-xbitmap"))  buffer.append("BMP 文件, ");
        if(accept.contains("image/jpeg")) buffer.append("JPG 文件, ");
        if(accept.contains("application/vnd.ms-excel"))  buffer.append("Excel 文件, ");
        if(accept.contains("application/vnd.ms-powerpoint")) buffer.append("PPT 文件, ");
        if(accept.contains("application/msword")) buffer.append("Word 文件, ");
        return buffer.toString().replaceAll(", $", "");
    }

    private String getLocale(Locale locale) {
        if(Locale.SIMPLIFIED_CHINESE.equals(locale))  return "简体中文";
        if(Locale.TRADITIONAL_CHINESE.equals(locale))  return "繁体中文";
        if(Locale.ENGLISH.equals(locale))  return "英文";
        if(Locale.JAPANESE.equals(locale))  return "日文";
        return "未知语言环境";
    }

    private String getAddress(String ip) {
        return "//TODO";
    }

    private String getNavigator(String userAgent) {
        if(userAgent.indexOf("TencentTraveler") > 0)  return "腾讯浏览器";
        if(userAgent.indexOf("Maxthon") > 0)  return "Maxthon浏览器";
        if(userAgent.indexOf("MyIE2") > 0)  return "MyIE2浏览器";
        if(userAgent.indexOf("Firefox") > 0)  return "Firefox浏览器";
        if(userAgent.indexOf("MSIE") > 0)  return "IE浏览器";
        return "未知浏览器";
    }

    private String getOS(String userAgent) {
        if(userAgent.indexOf("Windows NT 5.1") > 0)  return "Windows XP";
        if(userAgent.indexOf("Windows 98") > 0)  return "Windows 98";
        if(userAgent.indexOf("Windows NT 5.0") > 0) return "Windows 2000";
        if(userAgent.indexOf("Linux") > 0)  return "Linux";
        if(userAgent.indexOf("Unix") > 0)  return "Unix";
        return "未知";
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        response.setContentType("text/html");

        String authType = request.getAuthType();
        String localAddr = request.getLocalAddr();
        String localName = request.getLocalName();
        int localPort = request.getLocalPort();

        Locale locale = request.getLocale();
        String contextPath = request.getContextPath();
        String method = request.getMethod();
        String pathInfo = request.getPathInfo();
        String pathTranslated = request.getPathTranslated();
        String protocol = request.getProtocol();
        String queryString = request.getQueryString();
        String remoteAddr = request.getRemoteAddr();
        int port = request.getRemotePort();
        String remoteUser = request.getRemoteUser();
        String requestedSessionId = request.getRequestedSessionId();
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String servletPath = request.getServletPath();
        Principal userPrincipal = request.getUserPrincipal();

        String accept = request.getHeader("accept");
        String referer = request.getHeader("referer");
        String userAgent = request.getHeader("user-agent");
        String serverInfo = this.getServletContext().getServerInfo();

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>Request Servlet</TITLE></HEAD>");
        out.println("  <style>body, font, td, div {font-size:24px; line-height:28px; }</style>");
        out.println("  <BODY>");

        out.println("<b>您的IP为</b>" + remoteAddr + "<b>,位于</b>" + getAddress(remoteAddr) + "<b>；您使用</b>" + getOS(userAgent) + "<b>操作系统</b>，" + getNavigator(userAgent) + "<b>。您使用</b>" + getLocale(locale) + "。<br/>");
        out.println("<b>服务器IP为</b>" + localAddr + "<b>，位于</b>" + getAddress(localAddr) + "<b>；服务器使用</b>" + serverPort + "<b>端口，您的浏览器使用了</b>" + port + "<b>端口访问本网页。</b><br/>");
        out.println("<b>服务器软件为</b>:" + serverInfo + "。<b>服务器名称为</b>" + localName + "。<br/>");
        out.println("<b>您的浏览器接受</b>" + getAccept(accept) + "。<br/>");
        out.println("<b>您从</b>" + referer + "<b>访问到该页面。</b><br/>");
        out.println("<b>使用的协议为</b>" + protocol + "。<b>URL协议头</b>" + scheme + "，<b>服务器名称</b>" + serverName + "，<b>您访问的RUI为</b>" + requestURI + "。<br/>");
        out.println("<b>该Servlet路径为</b>" + servletPath + "，<b>该Servlet类名为</b>" + this.getClass().getName() + "。<br/>");
        out.println("<b>本应用程序在硬盘的根目录为</b>" + this.getServletContext().getRealPath("") + "，<b>网络相对路径为</b>" + contextPath + "。<br/>");
        out.println("<br/>");
        out.println("<br/>authType:" + authType);
        out.println("<br/>localPort:" + localPort);
        out.println("<br/>method:" + method);
        out.println("<br/>pathInfo:" + pathInfo);
        out.println("<br/>pathTranslated:" + pathTranslated);
        out.println("<br/>queryString:" + queryString);
        out.println("<br/>remoteUser:" + remoteUser);
        out.println("<br/>requestedSessionId:" + requestedSessionId);
        out.println("<br/>requestURL:" + requestURL);
        out.println("<br/>userPrincipal:" + userPrincipal);
        out.println("<br/><br/><a href=" + requestURI + ">单击刷新本页面</a>");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();

    }
}
