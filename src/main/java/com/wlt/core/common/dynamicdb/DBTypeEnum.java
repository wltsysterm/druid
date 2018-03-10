package com.wlt.core.common.dynamicdb;

public enum DBTypeEnum {
    /**
     * 测试库
     */
    TEST("test");
    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
