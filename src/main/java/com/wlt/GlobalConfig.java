package com.wlt;

/**
 * @author 魏霖涛
 * @since 2018/3/9 0009
 */
public class GlobalConfig {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GlobalConfig{" +
                "name='" + name + '\'' +
                '}';
    }
}
