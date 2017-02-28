package com.redweb.servlet.upload;

import org.apache.commons.fileupload.ProgressListener;

/**
 * Created by 11407 on 2017/2/23.
 */
public class UploadListener implements ProgressListener {
    private UploadStatus status;

    public UploadListener(UploadStatus status) {
        this.status = status;
    }

    public void update(long bytesRead, long contentLength, int items) {
        status.setByteRead(bytesRead);
        status.setContentLength(contentLength);
        status.setItems(items);
    }
}
