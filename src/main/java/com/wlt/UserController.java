package com.wlt;

import com.wlt.biz.service.test.IUserService;
import com.wlt.core.common.mvc.MsgResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 魏霖涛
 * @since 2018/3/8 0008
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private GlobalConfig globalConfig;
    @Autowired
    private IUserService iUserService;
    @RequestMapping("/list")
    public MsgResult list(){
        System.out.println("ioc容器启动之后完成自动注入"+globalConfig);
        return new MsgResult(iUserService.list());
    }
}
