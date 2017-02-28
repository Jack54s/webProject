package com.redweb.servlet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 11407 on 2017/2/22.
 */
@WebServlet(name = "Injection", urlPatterns = {"/Injection"})
public class Injection extends HttpServlet {

    @Resource(name="hello")
    private String hello;
    @Resource(name="i")
    private int i;
    @Resource(name="persons")
    private String persons;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>资源注入</HEAD></TITLE>");
        out.println("<style>body {font-size:12px; }</style>");

        out.println("  <BODY>");
        out.println("<b>注入的字符串</b>:<br/>&nbsp;&nbsp;&nbsp;-&nbsp;" + hello + "<br/>");
        out.println("<b>注入的整数</b>:<br/>&nbsp;&nbsp;-&nbsp;" + i + "<br/>");
        out.println("<b>注入的字符串数组</b>:<br/>");

        for (String person : persons.split(",")){
            out.println("&nbsp;&nbsp;-&nbsp;" + person +"<br/>");
        }

        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();

    }
}
