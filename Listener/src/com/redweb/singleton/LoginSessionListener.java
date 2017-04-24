package com.redweb.singleton;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 11407 on 2017/4/24.
 */
public class LoginSessionListener implements HttpSessionAttributeListener{
    Log log = LogFactory.getLog(this.getClass());
    Map<String, HttpSession> map = new HashMap<String, HttpSession>();

    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        if(name.equals("personInfo")) {
            PersonInfo personInfo = (PersonInfo) event.getValue();

            if(map.get(personInfo.getAccount()) != null) {
                HttpSession session = map.get(personInfo.getAccount());
                PersonInfo oldPersonInfo = (PersonInfo) session.getAttribute("personInfo");
                log.info("账号" + oldPersonInfo.getAccount() + "在" + oldPersonInfo.getIp() + "已经登录，该登录将被迫下线。");
                session.removeAttribute("personInfo");
                session.setAttribute("msg", "您的账号已经在其他机器上登录，您被迫下线。");
            }
            map.put(personInfo.getAccount(), event.getSession());
            log.info("账号" + personInfo.getAccount() + "在" + personInfo.getIp() + "登录。");
        }
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        String name = event.getName();
        if(name.equals("personInfo")) {
            PersonInfo personInfo = (PersonInfo) event.getValue();
            map.remove(personInfo.getAccount());
            log.info("账号" + personInfo.getAccount() + "注销。");
        }
    }
    public void attributeReplaced(HttpSessionBindingEvent event) {
        String name = event.getName();
        if(name.equals("personInfo")) {
            PersonInfo oldPersonInfo = (PersonInfo) event.getValue();
            map.remove(oldPersonInfo.getAccount());

            PersonInfo personInfo = (PersonInfo) event.getSession().getAttribute("personInfo");

            if(map.get(personInfo.getAccount()) != null) {
                HttpSession session = map.get(personInfo.getAccount());
                session.removeAttribute("personInfo");
                session.setAttribute("msg", "您的账号已经在其他机器上登录，您被迫下线。");
            }
            map.put(personInfo.getAccount(), event.getSession());
        }
    }
}
