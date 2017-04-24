package com.redweb.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by 11407 on 2017/3/10.
 */
public class SessionListenerTest implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent se) {

        HttpSession session = se.getSession();
        System.out.println("新建了一个session：" + session);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("销毁了一个session：" + session);
    }
}
