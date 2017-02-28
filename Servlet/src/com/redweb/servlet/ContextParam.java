package com.redweb.servlet;

import javax.servlet.ServletContext;
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
@WebServlet(name = "ContextParam", urlPatterns = {"/ContextParam"})
public class ContextParam extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>读取上下文参数</HEAD></TITLE>");
        out.println("  <link rel='stylesheet' type='text/css' href='../css/style.css'>");
        out.println("  <BODY>");
        out.println("<div align=center><br/>");
        out.println("<fieldset style='width:90%'><legend>所有的上下文参数</legend><br/>");

        ServletContext servletContext = getServletConfig().getServletContext();
        String uploadFolder = servletContext.getInitParameter("upload folder");
        String allowedFileType = servletContext.getInitParameter("allowed file type");

        out.println("<div class='line'>");
        out.println("  <div align='left' class='leftDiv'>上传文件夹</div>");
        out.println("  <div align='left' class='rightDiv'>" + uploadFolder + "</div>");
        out.println("</div>");
        out.println("<div class='line'>");
        out.println("  <div align='left' class='leftDiv'>实际磁盘路径</div>");
        out.println("  <div align='left' class='rightDIv'>" + servletContext.getRealPath(uploadFolder) + "</div>");
        out.println("</div>");
        out.println("<div class='line'>");
        out.println("  <div align='left' class='leftDiv'>允许上传的类型</div>");
        out.println("  <div align='left' class='rightDiv'>" + allowedFileType +"</div>");
        out.println("</div>");
        out.println("</fieldset></div>");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();

    }
}
