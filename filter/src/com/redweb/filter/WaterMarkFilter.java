package com.redweb.filter;

import com.redweb.response.WaterMarkResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 11407 on 2017/3/9.
 */
public class WaterMarkFilter implements Filter {

    private String waterMarkFile;

    @Override
    public void init (FilterConfig config) throws ServletException {
        String file = config.getInitParameter("waterMarkFile");
        waterMarkFile = config.getServletContext().getRealPath(file);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        WaterMarkResponseWrapper waterMarkRes = new WaterMarkResponseWrapper(response, waterMarkFile);

        chain.doFilter(request, waterMarkRes);

        waterMarkRes.finishResponse();
    }

    @Override
    public void destroy() {}
}
