package com.redweb.servlet;

import com.redweb.servlet.upload.UploadListener;
import com.redweb.servlet.upload.UploadStatus;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 11407 on 2017/2/23.
 */
@WebServlet(name = "ProgressUploadServlet", urlPatterns = {"/ProgressUploadServlet"})
public class ProgressUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UploadStatus status = new UploadStatus();
        UploadListener listener = new UploadListener(status);
        request.getSession(true).setAttribute("uploadStatus", status);

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File("F:/webProject/Servlet/web/WEB-INF/temp/"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(100*1024*1024);
        upload.setProgressListener(listener);

        try {
            List<FileItem> itemList = upload.parseRequest(request);

            for (FileItem item : itemList) {
                if (item.isFormField()) {
                    System.out.println("FormField:" + item.getFieldName() + " = " + item.getString("UTF-8"));
                }
                else {
                    System.out.println("File: " + item.getName());
                    //String fileName = item.getName().replace("/", "\\");
                    //fileName = fileName.substring((fileName.lastIndexOf("\\")));
                    File remoteFile = new File(new String(item.getName().getBytes(), "UTF-8"));
                    File saved = new File("F:/upload_test", remoteFile.getName());
                    saved.getParentFile().mkdirs();
                    saved.createNewFile();

                    InputStream ins = item.getInputStream();
                    OutputStream ous = new FileOutputStream(saved);
                    byte[] tmp = new byte[1024];
                    int len = 0;
                    while ((len = ins.read(tmp)) > -1) {
                        ous.write(tmp, 0, len);
                    }
                    ous.close();
                    ins.close();
                    response.getWriter().println("已保存文件：" + saved);
                }
            }
        }catch (Exception e) {
            response.getWriter().println("上传发生错误：" + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragrma", "no-cache");
        response.setDateHeader("Expires", 0);

        UploadStatus status = (UploadStatus) request.getSession(true).getAttribute("uploadStatus");
        if (status == null) {
            response.getWriter().println("没有上传信息");
            return;
        }

        long startTime = status.getStartTime();
        long currentTime = System.currentTimeMillis();
        long time = (currentTime - startTime) / 1000 + 1;

        double velocity = ((double)status.getByteRead())/(double) time;
        double totalTime = status.getContentLength() / velocity;
        double timeLeft = totalTime - time;
        int percent = (int) (100 * (double) status.getByteRead() / (double) status.getContentLength());
        double length = ((double) status.getByteRead()) /1024/1024;
        double totalLength = ((double) status.getContentLength()) / 1024/1024;
        String value = percent + "||" + length + "||" + totalLength + "||" + velocity + "||" + time + "||" + totalTime + "||" + timeLeft + "||" + status.getItems();
        response.getWriter().println(value);
    }
}
