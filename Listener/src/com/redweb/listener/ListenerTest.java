package com.redweb.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by 11407 on 2017/3/10.
 */
public class ListenerTest implements HttpSessionListener,
        ServletContextListener, ServletRequestListener {
    Log log = LogFactory.getLog(getClass());

    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        log.info("新创建了一个session，ID为：" + session.getId());
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        log.info("销毁了一个session，ID为：" + session.getId());
    }

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        log.info("即将启动" + servletContext.getContextPath());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        log.info("即将关闭" + servletContext.getContextPath());
    }

    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        String uri = request.getRequestURI();
        uri = request.getQueryString() == null ? uri : (uri + "?" + request.getQueryString());
        request.setAttribute("dateCreated", System.currentTimeMillis());
        log.info("IP" + request.getRemoteAddr() + "请求" + uri);
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        long time = System.currentTimeMillis() - (Long) request.getAttribute("dateCreated");
        log.info(request.getRemoteAddr() + "请求处理结束，用时" + time + "毫秒。");
    }
}
