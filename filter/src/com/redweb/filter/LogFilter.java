package com.redweb.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 11407 on 2017/3/8.
 */
public class LogFilter implements Filter {
    private Log log = LogFactory.getLog(this.getClass());
    private String filterName;

    public void init(FilterConfig config) throws ServletException {
        filterName = config.getFilterName();
        log.info("启动Filter：" + filterName);
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        long startTime = System.currentTimeMillis();
        String requestURI = request.getRequestURI();

        requestURI = request.getQueryString() == null ? requestURI : (requestURI + "?" + request.getQueryString());

        chain.doFilter(request, response);

        long endTime = System.currentTimeMillis();

        log.info(request.getRemoteAddr() + "访问了" + requestURI + ",总用时 " + (endTime - startTime) + " 毫秒。");
    }

    public void destroy() {
        log.info("关闭Filter：" + filterName);
    }
}
