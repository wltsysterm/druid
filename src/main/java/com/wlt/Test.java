package com.wlt;

import com.wlt.biz.entity.User;
import com.wlt.biz.service.test.IUserService;
import com.wlt.biz.service.test.impl.UserServiceImpl;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 魏霖涛
 * @since 2018/3/8 0008
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml"})
public class Test {
    private static ApplicationContext context;
//    @Autowired
//    IUserService userService;
    @Autowired
    GlobalConfig globalConfig;
//    @BeforeClass
//    public static void init() {
//        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
//    }
    @org.junit.Test
    public void test() {
//        IUserService userService = (UserServiceImpl)context.getBean("userServiceImpl");
//        List<User> list = userService.list();
//        System.out.println(list);
        System.out.println(globalConfig);
    }
}
