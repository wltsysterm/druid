package com.wlt.biz.service.test.impl;

import com.wlt.biz.entity.User;
import com.wlt.biz.mapper.UserMapper;
import com.wlt.biz.service.test.IUserService;
import com.wlt.core.common.mybatisplus.FtBaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * InnoDB free: 4096 kB 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2018-03-08
 */
@Service
public class UserServiceImpl extends FtBaseServiceImpl<UserMapper, User> implements IUserService {
	@Override
    public List<User> list(){
        List<User> list = this.selectList(null);
        return list;
    }
}
