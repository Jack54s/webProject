package com.redweb.request;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by 11407 on 2017/3/10.
 */
public class UploadRequestWrapper extends HttpServletRequestWrapper {

    private static final String MULTIPART_HEADER = "Content-type";

    private boolean multipart;

    private Map<String, Object> params = new HashMap<String, Object>();

    @SuppressWarnings("all")
    public UploadRequestWrapper(HttpServletRequest request) {
        super(request);
        multipart = request.getHeader(MULTIPART_HEADER) != null
                && request.getHeader(MULTIPART_HEADER).startsWith("multipart/form-data");

        if(multipart) {
            try {
                DiskFileUpload upload = new DiskFileUpload();
                upload.setHeaderEncoding("utf8");
                List<FileItem> fileItems = upload.parseRequest(request);

                for (Iterator<FileItem> it = fileItems.iterator(); it.hasNext();) {

                    FileItem item = it.next();

                    if(item.isFormField()) {
                        params.put(item.getFieldName(), item.getString("utf8"));
                    }
                    else {
                        String filename = item.getName().replace("\\", "/");
                        filename = filename.substring(filename.lastIndexOf("/") + 1);
                        File file = new File(System.getProperty("java.io.tmpdir"), filename);

                        OutputStream ous = new FileOutputStream(file);
                        ous.write(item.get());
                        ous.close();

                        params.put(item.getFieldName(), file);
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object getAttribute(String name) {

        if(multipart && params.containsKey(name)) {
            return params.get(name);
        }
        return super.getAttribute(name);
    }

    @Override
    public String getParameter(String name) {

        if (multipart && params.containsKey(name)) {
            return params.get(name).toString();
        }
        return super.getParameter(name);
    }
}
