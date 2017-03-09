package com.redweb.filter;

import com.redweb.response.GZipResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 11407 on 2017/3/9.
 */
public class GZipFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String acceptEncoding = request.getHeader("Accept-Encoding");

        if(acceptEncoding != null && acceptEncoding.toLowerCase().indexOf("gzip") != -1) {
            GZipResponseWrapper gzipRes = new GZipResponseWrapper(response);

            chain.doFilter(request, gzipRes);

            gzipRes.finishResponse();
        }
        else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {}
}
