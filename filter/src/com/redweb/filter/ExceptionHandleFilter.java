package com.redweb.filter;

import com.redweb.exception.BusinessException;
import com.redweb.exception.AccountException;
import javax.servlet.*;
import java.io.IOException;

/**
 * Created by 11407 on 2017/3/8.
 */
public class ExceptionHandleFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            Throwable rootCause = e;
            while (rootCause.getCause() != null) {
                rootCause = rootCause.getCause();
            }

            String message = rootCause.getMessage();
            message = message == null ? "异常：" + rootCause.getClass().getName() : message;
            request.setAttribute("message", message);
            request.setAttribute("e", e);

            if(rootCause instanceof AccountException) {
                request.getRequestDispatcher("/accountException.jsp").forward(request, response);
            }
            else if(rootCause instanceof BusinessException) {
                request.getRequestDispatcher("/businessException.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("/exception.jsp").forward(request, response);
            }
        }
    }
    public void destroy() {}
}
