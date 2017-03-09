package com.redweb.response;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by 11407 on 2017/3/9.
 */
public class WaterMarkOutputStream extends ServletOutputStream {

    private ByteArrayOutputStream byteArrayOutputStream;

    public WaterMarkOutputStream() throws IOException {
        byteArrayOutputStream = new ByteArrayOutputStream();
    }
    public void write(int b) throws IOException {
        byteArrayOutputStream.write(b);
    }

    public void close() throws IOException {
        byteArrayOutputStream.close();
    }

    public void flush() throws IOException {
        byteArrayOutputStream .flush();
    }

    public void write(byte[] b, int off, int len) throws IOException {
        byteArrayOutputStream.write(b, off, len);
    }

    public void write(byte[] b) throws IOException {
        byteArrayOutputStream.write(b);
    }

    public ByteArrayOutputStream getByteArrayOutputStream() {
        return byteArrayOutputStream;
    }

    public boolean isReady(){ return true;}

    public void setWriteListener(WriteListener var1){}
}
