package com.redweb.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.Date;

/**
 * Created by 11407 on 2017/3/3.
 */
@WebServlet(name = "Forward", urlPatterns = {"/Forward"})
public class Forward extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = request.getParameter("destination");

        if("file".equals(destination)) {
            RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/web.xml");
            d.forward(request, response);
        }
        else if("jsp".equals(destination)) {
            request.setAttribute("date", new Date());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/forward.jsp");
            dispatcher.forward(request, response);
        }
        else if("servlet".equals(destination)) {
            RequestDispatcher d = request.getRequestDispatcher("/LifeCycle");
            d.forward(request, response);
        }
        else {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println("缺少参数。用法：" + request.getRequestURL() + "?destination=jsp 或者 file 或者 servlet");
        }
    }
}
