package com.redweb.firstweb.HelloServlet;

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
@WebServlet(name = "HelloServlet",urlPatterns = {"/HelloServlet"})
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
        out.println("<HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");

        String requestURI = request.getRequestURI();
        out.println("<form action='" + requestURI + "' method='post'>");
        out.println("请输入您的名字：<input type='text' name='name' />");
        out.println("<input type='submit' />");
        out.println("</form>");
        out.println("");

        String name = request.getParameter("name");
        if (name != null && name.trim().length() > 0) {
            out.println("您好，<b>" + name + "<b>. 欢迎来到JavaWeb世界。");
        }
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);

    }
}
