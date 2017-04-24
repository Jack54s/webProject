package com.redweb.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 11407 on 2017/4/24.
 */
public class MyRequestListener implements ServletRequestListener {
    public void requestDestroyed(ServletRequestEvent event) {}

    public void requestInitialized(ServletRequestEvent event) {

        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
        HttpSession session = request.getSession(true);
        session.setAttribute("ip", request.getRemoteAddr());

        String uri = request.getRequestURI();
        String[] suffix = {".html", ".do", ".jsp", ".action"};
        for (int i=0; i<suffix.length; i++) {
            if(uri.endsWith(suffix[i])) {
                break;
            }
            if(i == suffix.length - 1) {
                return;
            }
        }

        Integer activeTimes = (Integer) session.getAttribute("activeTimes");
        if(activeTimes == null) {
            activeTimes = 0;
        }
        session.setAttribute("activeTimes", activeTimes + 1);
    }
}
