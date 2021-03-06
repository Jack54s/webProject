package com.redweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 11407 on 2017/2/20.
 */
@WebServlet(name = "FirstServlet",urlPatterns = {"/FirstServlet"})
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.log("执行doPost方法...");
        this.execute(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.log("执行doGet方法...");
        this.execute(request, response);
    }

    @Override
    public long getLastModified(HttpServletRequest request) {
        this.log("执行getLastModified方法...");
        return 0;
    }

    private  void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        String param = request.getParameter("param");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.println("  以" + method + "方式访问该页面。取到的param参数为：" + param + "<br/>");
        out.println("  <form action='" + requestURI + "' method='get'><input type='text' name='param' value='param string'><input type='submit' value='以GET方式查询页面" + requestURI + "'></form>");
        out.println("  <form action='" + requestURI + "' method='post'><input type='text' name='param' value='param string'><input type='submit' value='以POST方式查询页面" + requestURI + "'></form>");

        out.println("  <script>document.write('本页面最后更新时间：' + document.lastModified); </script>");

        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}

