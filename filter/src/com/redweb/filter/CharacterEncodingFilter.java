package com.redweb.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by 11407 on 2017/3/8.
 */
public class CharacterEncodingFilter implements Filter {

    private String characterEncoding;
    private boolean enabled;

    public void init(FilterConfig config) throws ServletException {
        characterEncoding = config.getInitParameter("characterEncoding");

        enabled = "true".equalsIgnoreCase(config.getInitParameter("enabled").trim());
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(enabled || characterEncoding != null) {
            request.setCharacterEncoding(characterEncoding);
            response.setCharacterEncoding(characterEncoding);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        characterEncoding = null;
    }
}
