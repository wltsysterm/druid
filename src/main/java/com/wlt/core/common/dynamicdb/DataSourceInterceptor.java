package com.wlt.core.common.dynamicdb;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceInterceptor.class);

    public void setTest() {
        DbContextHolder.setDbType(DBTypeEnum.TEST);
        logger.debug("当前数据源："+DbContextHolder.getDbType());
    }
    public void setDb(JoinPoint jp) {
        String packageName = jp.getTarget().getClass().getPackage().getName();
        if (packageName.contains(".test.")) {
            DbContextHolder.setDbType(DBTypeEnum.TEST);
        }else {
            //设置默认数据源
            DbContextHolder.setDbType(DBTypeEnum.TEST);
        }
        logger.debug("当前数据源："+DbContextHolder.getDbType());
    }
}
