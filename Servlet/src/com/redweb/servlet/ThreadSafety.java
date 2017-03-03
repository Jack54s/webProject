package com.redweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 11407 on 2017/3/3.
 */
@WebServlet(name = "ThreadSafety", urlPatterns = {"/ThreadSafety"})
public class ThreadSafety extends HttpServlet {
//    private String name;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*name = request.getParameter("name");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("您好，" + name + ".您使用了POST方式提交数据");*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name;
        name = request.getParameter("name");
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e) {}
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("您好，" + name + ".您使用了GET方式提交数据");
    }
}
