package com.redweb.listener;

import com.redweb.util.ApplicationConstants;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;

/**
 * Created by 11407 on 2017/4/24.
 */
public class MyContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        ApplicationConstants.START_DATE = new Date();
    }

    public void contextDestroyed(ServletContextEvent event) {
        ApplicationConstants.START_DATE = null;
        ApplicationConstants.MAX_ONLINE_COUNT_DATE = null;
    }
}
