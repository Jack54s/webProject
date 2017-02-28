package com.redweb.servlet;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by 11407 on 2017/2/22.
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
public class UploadServlet extends HttpServlet {
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File file1 = null, file2 = null;
        String description1 = null, description2 = null;

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out =response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>上传文件</TITLE></HEAD> ");
        out.println("  <BODY>");

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File("F:/webProject/Servlet/web/WEB-INF/temp/"));
        ServletFileUpload diskFileUpload = new ServletFileUpload(factory);
        diskFileUpload.setSizeMax(100*1024*1024);

        try {
            List<FileItem> list = diskFileUpload.parseRequest(request);
            out.println("遍历所有的FileItem ... <br/>");
            for(FileItem fileItem : list) {
                if(fileItem.isFormField()){
                    if("description1".equals(fileItem.getFieldName())) {
                        out.println("遍历到description1 ... <br/>");
                        description1 = fileItem.getString("UTF-8");
                    }
                    if("description2".equals(fileItem.getFieldName())) {
                        out.println("遍历到description2 ... <br/>");
                        description2 = fileItem.getString("UTF-8");
                    }
                }
                else {
                    if("file1".equals(fileItem.getFieldName())) {
                        File remoteFile = new File(new String(fileItem.getName().getBytes(), "UTF-8"));
                        out.println("遍历到file1 ... <br/>");
                        out.println("客户端文件位置：" + remoteFile.getAbsolutePath() + "<br/>");
                        file1 = new File(this.getServletContext().getRealPath("upload"), remoteFile.getName());
                        file1.getParentFile().mkdirs();
                        file1.createNewFile();

                        InputStream ins = fileItem.getInputStream();
                        OutputStream ous =  new FileOutputStream(file1);

                        try {
                            byte[] buffer = new byte[1024];
                            int len = 0;
                            while((len = ins.read(buffer)) > -1)
                                ous.write(buffer, 0, len);
                            out.println("已保存文件" + file1.getAbsolutePath() + "<br/>");
                        }finally {
                            ous.close();
                            ins.close();
                        }
                    }
                    if("file2".equals(fileItem.getFieldName())) {
                        File remoteFile = new File(new String(fileItem.getName().getBytes(), "UTF-8"));
                        out.println("遍历到file2 ... <br/>");
                        out.println("客户端文件位置：" + remoteFile.getAbsolutePath() + "<br/>");
                        file2 = new File(this.getServletContext().getRealPath("upload"), remoteFile.getName());
                        file2.getParentFile().mkdirs();
                        file2.createNewFile();

                        InputStream ins = fileItem.getInputStream();
                        OutputStream ous =  new FileOutputStream(file2);

                        try {
                            byte[] buffer = new byte[1024];
                            int len = 0;
                            while((len = ins.read(buffer)) > -1)
                                ous.write(buffer, 0, len);
                            out.println("已保存文件" + file2.getAbsolutePath() + "<br/>");
                        }finally {
                            ous.close();
                            ins.close();
                        }
                    }
                }
            }
            out.println("Request 解析完毕");
        }catch (Exception e){}
        if(file1 != null) {
            out.println("    <div class='line'>");
            out.println("      <div align='left' class='leftDiv'>file1:</div>");
            out.println("      <div align='left' class='rightDiv'>");
            out.println("        <a href='" + request.getContextPath() + "/upload/" + file1.getName() + "' target=_blank>" + file1.getName() + "</a>");
            out.println("      </div>");
            out.println("    </div>");
        }
        if(file2 != null) {
            out.println("    <div class='line'>");
            out.println("      <div align='left' class='leftDiv'>file2:</div>");
            out.println("      <div align='left' class='rightDiv'>");
            out.println("        <a href='" + request.getContextPath() + "/upload/" + file2.getName() + "' target=_blank>" + file2.getName() + "</a>");
            out.println("      </div>");
            out.println("    </div>");
        }
        out.println("    <div class='line'>");
        out.println("      <div align='left' class='leftDiv'>description1:</div>");
        out.println("      <div align='left' class='rightDiv'>");
        out.println(description1);
        out.println("      </div>");
        out.println("    </div>");
        out.println("    <div class='line'>");
        out.println("      <div align='left' class='leftDiv'>description2:</div>");
        out.println("      <div align='left' class='rightDiv'>");
        out.println(description2);
        out.println("      </div>");
        out.println("    </div>");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("请以POST方式上传文件");

    }
}
