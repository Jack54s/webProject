package com.redweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by 11407 on 2017/2/22.
 */
@WebServlet(name = "InitParam", urlPatterns = {"/InitParam"})
public class InitParam extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Enumeration params = this.getInitParameterNames();

        while(params.hasMoreElements()) {
            String usernameParam = (String)params.nextElement();
            String passnameParam = getInitParameter(usernameParam);

            if(usernameParam.equalsIgnoreCase(username) && passnameParam.equals(password)) {
                request.getRequestDispatcher("/WEB-INF/notice.html").forward(request, response);
                return;
            }
        }
        this.doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>请登录查看Notice文件</TITLE></HEAD>");
        out.println("<style>body, td, div {font-size: 12px; }</style>");
        out.println("  <BODY>");

        out.println("<form action='" + request.getRequestURI() + "'method='post'>");
        out.println("账号：<input type='text' name='username' style='width:200px;'><br/>");
        out.println("密码：<input type='password' name='password' style='width:200px;'><br/><br/>" );
        out.println("<input type='submit' value='  登录  '>");
        out.println("</form>");

        out.println("  </BODY>");
        out.println("</HTML>");

        out.flush();
        out.close();

    }
}
