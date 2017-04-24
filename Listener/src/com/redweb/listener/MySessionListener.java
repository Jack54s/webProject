package com.redweb.listener;

import com.redweb.util.ApplicationConstants;

import javax.servlet.http.*;
import java.util.Date;

/**
 * Created by 11407 on 2017/4/24.
 */
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        HttpSession session = sessionEvent.getSession();
        ApplicationConstants.SESSION_MAP.put(session.getId(), session);
        ApplicationConstants.TOTAL_HISTORY_COUNT++;

        if(ApplicationConstants.SESSION_MAP.size() > ApplicationConstants.MAX_ONLINE_COUNT) {
            ApplicationConstants.MAX_ONLINE_COUNT = ApplicationConstants.SESSION_MAP.size();
            ApplicationConstants.MAX_ONLINE_COUNT_DATE = new Date();
        }
    }

    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        HttpSession session = sessionEvent.getSession();
        ApplicationConstants.SESSION_MAP.remove(session.getId());
    }

    public void attributeAdded(HttpSessionBindingEvent event) {
        if(event.getName().equals("personInfo")) {
            ApplicationConstants.CURRENT_LOGIN_COUNT++;
            HttpSession session = event.getSession();

            for (HttpSession sess : ApplicationConstants.SESSION_MAP.values()) {
                if(event.getValue().equals(sess.getAttribute("personInfo")) && session.getId() != sess.getId()) {
                    sess.invalidate();
                }
            }
        }
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        if(event.getName().equals("personInfo")) {
            ApplicationConstants.CURRENT_LOGIN_COUNT--;
        }
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        if(event.getName().equals("personInfo")) {
            HttpSession session = event.getSession();
            for (HttpSession sess : ApplicationConstants.SESSION_MAP.values()) {
                if(event.getValue().equals(sess.getAttribute("personInfo")) && session.getId() != sess.getId()) {
                    sess.invalidate();
                }
            }
        }
    }
}
