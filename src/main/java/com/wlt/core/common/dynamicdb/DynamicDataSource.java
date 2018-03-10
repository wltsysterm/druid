package com.wlt.core.common.dynamicdb;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println(DbContextHolder.getDbType());
        return DbContextHolder.getDbType();
    }
}
