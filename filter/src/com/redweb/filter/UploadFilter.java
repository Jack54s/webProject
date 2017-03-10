package com.redweb.filter;

import com.redweb.request.UploadRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by 11407 on 2017/3/10.
 */
public class UploadFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        UploadRequestWrapper uploadRequest = new UploadRequestWrapper((HttpServletRequest)request);

        chain.doFilter(uploadRequest, response);
    }

    public void destroy() {}
}
