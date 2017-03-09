package com.redweb.filter;

import com.redweb.response.CacheResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by 11407 on 2017/3/9.
 */
public class CacheFilter implements Filter {

    private ServletContext servletContext;
    private File temporalDir;
    private long cacheTime = Long.MAX_VALUE;

    public void init(FilterConfig config) throws ServletException {
        temporalDir = (File)config.getServletContext().getAttribute("javax.servlet.context.tempdir");
        servletContext = config.getServletContext();
        cacheTime = new Long(config.getInitParameter("cacheTime"));
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if("POST".equals(request.getMethod())) {
            chain.doFilter(request, response);
            return;
        }

        String uri = request.getRequestURI();
        if(uri == null)
            uri = "";
        uri = uri.replace(request.getContextPath() + "/", "");
        uri = uri.trim().length() == 0 ? "index.jsp" : uri;
        uri = request.getQueryString() == null ? uri : (uri + "?" + request.getQueryString());

        File cacheFile = new File(temporalDir, URLEncoder.encode(uri, "UTF-8"));

        System.out.println(cacheFile);

        if(!cacheFile.exists() || cacheFile.length() == 0 || cacheFile.lastModified() < System.currentTimeMillis() - cacheTime) {
            CacheResponseWrapper cacheResponse = new CacheResponseWrapper(response);
            chain.doFilter(request, response);
            char[] content = cacheResponse.getCacheWriter().toCharArray();

            temporalDir.mkdirs();
            cacheFile.createNewFile();

            Writer writer = new OutputStreamWriter(new FileOutputStream(cacheFile), "UTF-8");
            writer.write(content);
            writer.close();
        }

        String mimeType = servletContext.getMimeType(request.getRequestURI());
        response.setContentType(mimeType);

        Reader ins = new InputStreamReader(new FileInputStream(cacheFile), "UTF-8");
        StringBuffer buffer = new StringBuffer();
        char[] cbuf = new char[1024];
        int len;
        while ((len = ins.read(cbuf)) > -1) {
            buffer.append(cbuf, 0, len);
        }
        ins.close();
        response.getWriter().write(buffer.toString());
    }
    public void destroy() {}
}
