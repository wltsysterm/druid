package com.wlt.biz.service.test;

import com.baomidou.mybatisplus.service.IService;
import com.wlt.biz.entity.User;
import com.wlt.core.common.mybatisplus.FtBaseService;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 服务类
 * </p>
 *
 * @author ${author}
 * @since 2018-03-08
 */
public interface IUserService extends FtBaseService<User> {

    List<User> list();
}
