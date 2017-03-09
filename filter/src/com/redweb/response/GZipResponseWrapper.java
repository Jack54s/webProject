package com.redweb.response;

import com.redweb.response.GZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created by 11407 on 2017/3/9.
 */
public class GZipResponseWrapper extends HttpServletResponseWrapper {

    private HttpServletResponse response;

    private GZipOutputStream gzipOutputStream;

    private PrintWriter writer;

    public GZipResponseWrapper(HttpServletResponse response) throws IOException {
        super(response);
        this.response = response;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        if(gzipOutputStream == null)
            gzipOutputStream = new GZipOutputStream(response);
        return gzipOutputStream;
    }

    public PrintWriter getWriter() throws IOException {
        if(writer == null)
            writer = new PrintWriter(new OutputStreamWriter(new GZipOutputStream(response), "UTF-8"));
        return writer;
    }

    public void setContentLength(int contentLength) {
    }

    public void flushBuffer() throws IOException {
        gzipOutputStream.flush();
    }

    public void finishResponse() throws IOException {
        if(gzipOutputStream != null)
            gzipOutputStream.close();
        if(writer != null)
            writer.close();
    }
}
