package com.redweb.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 11407 on 2017/3/10.
 */
public class PersonInfo implements HttpSessionActivationListener,
        HttpSessionBindingListener, Serializable {

    private static final long serialVersionUID = -4780592776386225973L;

    Log log = LogFactory.getLog(getClass());
    private String name;
    private Date dateCreated;

    public void setName(String name) {
        this.name = name;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void valueBound(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        String name = event.getName();
        log.info(this + "被绑定到session\"" + session.getId() + "\"的" + name + "属性上");

        this.setDateCreated(new Date());
    }

    public void valueUnbound(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        String name = event.getName();
        log.info(this + "被从session\"" + session.getId() + "\"的" + name + "属性上移除");
    }

    public void sessionDidActivate(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        log.info(this + "已经成功从硬盘中加载。sessionId:" + session.getId());
    }

    public void sessionWillPassivate(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        log.info(this + "即将保存到硬盘。sessionId：" + session.getId());
    }

    @Override
    public String toString() {
        return "PersonInfo(" + name + ")";
    }
}
