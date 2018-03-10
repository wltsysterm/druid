//package com.wlt.core.common.dynamicdb;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Map.Entry;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.jdbc.datasource.AbstractDataSource;
//import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
//import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
//import org.springframework.util.Assert;
//
//public abstract class AbstractRoutingDataSource extends AbstractDataSource implements InitializingBean {
//    /**
//     * （baen初始化时候属性设置）目标数据源-存储的有可能是jndi映射的数据源的名称，Map结构，存储多个key-databasesource。
//     */
//    private Map<Object, Object> targetDataSources;
//    /**
//     * （baen初始化时候属性设置）默认数据源-存储的有可能是jndi映射的数据源的名称，当没有配置目标数据源，或者没有指定数据源，就用默认数据源
//     */
//    private Object defaultTargetDataSource;
//
//    private boolean lenientFallback = true;
//    /**
//     * 查找数据源  接口的名称，通过传入jndi的名称，从tomcat或者其他的应用服务器获取数据源
//     */
//    private DataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
//    /**
//     * （实际应用）目标数据源，存储的就是真实的数据源
//     */
//    private Map<Object, DataSource> resolvedDataSources;
//    /**
//     * （实际应用）默认数据源，真实的数据源
//     */
//    private DataSource resolvedDefaultDataSource;
//
//    public AbstractRoutingDataSource() {
//    }
//
//    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
//        this.targetDataSources = targetDataSources;
//    }
//
//    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
//        this.defaultTargetDataSource = defaultTargetDataSource;
//    }
//
//    public void setLenientFallback(boolean lenientFallback) {
//        this.lenientFallback = lenientFallback;
//    }
//
//    public void setDataSourceLookup(DataSourceLookup dataSourceLookup) {
//        this.dataSourceLookup = (DataSourceLookup)(dataSourceLookup != null ? dataSourceLookup : new JndiDataSourceLookup());
//    }
//
//    /**
//     * 实现了InitializingBean接口方法afterPropertiesSet：bean初始化的时候会自动执行该方法；从名称翻译意思是：当属性设置完之后执行的方法
//     * 执行完该方法的效果：
//     *  resolvedDataSources填充了配置在targetDataSources里头预先配置的数据源或者jndi名称所映射到的数据源
//     *  resolvedDefaultDataSource指向了defaultTargetDataSource里头预先配置的数据源或者jndi名称所映射到的数据源
//     */
//    public void afterPropertiesSet() {
//        if (this.targetDataSources == null) {
//            throw new IllegalArgumentException("Property 'targetDataSources' is required");
//        } else {
//            this.resolvedDataSources = new HashMap(this.targetDataSources.size());
//            Iterator var1 = this.targetDataSources.entrySet().iterator();
//
//            while(var1.hasNext()) {
//                Entry<Object, Object> entry = (Entry)var1.next();
//                Object lookupKey = this.resolveSpecifiedLookupKey(entry.getKey());
//                DataSource dataSource = this.resolveSpecifiedDataSource(entry.getValue());
//                this.resolvedDataSources.put(lookupKey, dataSource);
//            }
//
//            if (this.defaultTargetDataSource != null) {
//                this.resolvedDefaultDataSource = this.resolveSpecifiedDataSource(this.defaultTargetDataSource);
//            }
//
//        }
//    }
//
//    protected Object resolveSpecifiedLookupKey(Object lookupKey) {
//        return lookupKey;
//    }
//
//    /**
//     * 根据dataSource获取数据源
//     * 如果dataSource是数据源对象，那么直接返回
//     * 如果dataSource只是一个jndi的名称，那么通过该名称去映射到tomcat或者其他服务器配置的数据源，并返回该数据源
//     * @param dataSource
//     * @return
//     * @throws IllegalArgumentException
//     */
//    protected DataSource resolveSpecifiedDataSource(Object dataSource) throws IllegalArgumentException {
//        if (dataSource instanceof DataSource) {
//            return (DataSource)dataSource;
//        } else if (dataSource instanceof String) {
//            //实现类JNDI统一接口提供查找和访问各种命名和目录服务，根据
//            return this.dataSourceLookup.getDataSource((String)dataSource);
//        } else {
//            throw new IllegalArgumentException("Illegal data source value - only [javax.sql.DataSource] and String supported: " + dataSource);
//        }
//    }
//
//    public Connection getConnection() throws SQLException {
//        return this.determineTargetDataSource().getConnection();
//    }
//
//    public Connection getConnection(String username, String password) throws SQLException {
//        return this.determineTargetDataSource().getConnection(username, password);
//    }
//
//    public <T> T unwrap(Class<T> iface) throws SQLException {
//        return iface.isInstance(this) ? this : this.determineTargetDataSource().unwrap(iface);
//    }
//
//    public boolean isWrapperFor(Class<?> iface) throws SQLException {
//        return iface.isInstance(this) || this.determineTargetDataSource().isWrapperFor(iface);
//    }
//
//    /**
//     * 根据determineCurrentLookupKey()返回的key查找要使用的数据源,如果找不到，返回默认的数据源
//     * @return
//     */
//    protected DataSource determineTargetDataSource() {
//        Assert.notNull(this.resolvedDataSources, "DataSource router not initialized");
//        Object lookupKey = this.determineCurrentLookupKey();
//        DataSource dataSource = (DataSource)this.resolvedDataSources.get(lookupKey);
//        if (dataSource == null && (this.lenientFallback || lookupKey == null)) {
//            dataSource = this.resolvedDefaultDataSource;
//        }
//
//        if (dataSource == null) {
//            throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + lookupKey + "]");
//        } else {
//            return dataSource;
//        }
//    }
//
//    /**
//     * 需要一个子类去实现这个抽象方法，返回一个datasource的key
//     * @return
//     */
//    protected abstract Object determineCurrentLookupKey();
//}
