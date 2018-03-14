package com.wlt.core.common.context;

import com.wlt.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 魏霖涛
 * @since 2018/3/10 0010
 */
public class ApplicationContext implements ServletContextListener {
    @Autowired
    private GlobalConfig globalConfig;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("getBean方式"+SpringUtils.getBean("globalConfig"));
        System.out.println("listener容器启动的时候还没有注入"+globalConfig);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
