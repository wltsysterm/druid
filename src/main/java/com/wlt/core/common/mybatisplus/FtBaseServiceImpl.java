package com.wlt.core.common.mybatisplus;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

public class FtBaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {
}
