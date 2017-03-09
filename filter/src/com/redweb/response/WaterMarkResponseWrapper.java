package com.redweb.response;

import com.redweb.util.ImageUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * Created by 11407 on 2017/3/9.
 */
public class WaterMarkResponseWrapper extends HttpServletResponseWrapper {

    private String waterMarkFile;
    private HttpServletResponse response;

    private WaterMarkOutputStream waterMarkOutputStream = new WaterMarkOutputStream();
    public WaterMarkResponseWrapper(HttpServletResponse response, String waterMarkFile) throws IOException {
        super(response);
        this.response = response;
        this.waterMarkFile = waterMarkFile;
    }

    public ServletOutputStream getOutputStream() throws IOException {
        return waterMarkOutputStream;
    }

    public void flushBuffer() throws IOException {
        waterMarkOutputStream.flush();
    }

    public void finishResponse() throws IOException {
        byte[] imageData = waterMarkOutputStream.getByteArrayOutputStream().toByteArray();

        byte[] image = ImageUtil.waterMark(imageData, waterMarkFile);

        response.setContentLength(image.length);
        response.getOutputStream().write(image);

        waterMarkOutputStream.close();
    }
}
