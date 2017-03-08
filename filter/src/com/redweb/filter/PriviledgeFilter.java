package com.redweb.filter;

import com.redweb.exception.AccountException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by 11407 on 2017/3/8.
 */
public class PriviledgeFilter implements Filter {

    private Properties pp = new Properties();

    public void init(FilterConfig config) throws ServletException {
        String file = config.getInitParameter("file");
        String realPath = config.getServletContext().getRealPath(file);

        try {
            pp.load(new FileInputStream(realPath));
        }catch (Exception e) {
            config.getServletContext().log("读取权限控制文件失败。", e);
        }
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String requestURI = request.getRequestURI().replace(request.getContextPath() + "/", "");
        String action = req.getParameter("action");

        action = action == null ? "" : action;
        String uri = requestURI + "?action=" + action;

        String role = (String) request.getSession(true).getAttribute("role");
        role = role == null ? "guest" :role;

        boolean authentificated = false;

        for (Object obj : pp.keySet()) {
            String key = (String) obj;

            if(uri.matches(key.replace("?", "\\?").replace(".", "\\.").replace("*", ".*"))) {
                if(role.equals(pp.get(key))) {
                    authentificated = true;
                    break;
                }
            }
        }
        if(!authentificated) {
            throw new RuntimeException(new AccountException("您无权访问该页面。请以合适的身份登录后查看。"));
        }

        chain.doFilter(req, res);
    }
    public void destroy() {
        pp = null;
    }
}
