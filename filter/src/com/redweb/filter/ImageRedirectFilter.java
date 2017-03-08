package com.redweb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 11407 on 2017/3/8.
 */
public class ImageRedirectFilter implements Filter{

    public void init(FilterConfig config) throws ServletException {}

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String referer = request.getHeader("referer");

        if(referer == null || !referer.contains(request.getServerName())) {
            request.getRequestDispatcher("/error.gif").forward(request, response);
        }
        else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {}
}
