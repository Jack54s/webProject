package com.redweb.servlet.upload;

/**
 * Created by 11407 on 2017/2/23.
 */
public class UploadStatus {
    private long bytesRead;
    private long contentLength;
    private int items;
    private long startTime = System.currentTimeMillis();

    public long getByteRead() {
        return bytesRead;
    }
    public void setByteRead(long bytesRead) {
        this.bytesRead = bytesRead;
    }
    public long getContentLength() {
        return contentLength;
    }
    public void setContentLength(long contentLength) {
        this.contentLength = contentLength;
    }
    public int getItems() {
        return items;
    }
    public void setItems(int items) {
        this.items = items;
    }
    public long getStartTime() {
        return startTime;
    }
    public void setStartTime(long startTime) {
    this.startTime = startTime;
    }
}