package com.wlt.core.common.dynamicdb;

/**
 * 枚举学习
 * @author 魏霖涛
 * @since 2018/3/7 0007
 */
public class Test {
    public static void main(String[] args) {
        debug("无构造函数", "================");
        debug("valueOf", Season.valueOf("SPRING"));
        debug("name", Season.SUMMER.name());
        debug("ordinal()", "返回当前枚举对象的序数/索引");
        debug("ordinal", Season.SUMMER.ordinal());
        for (Season season : Season.values()) {
            debug("values", season.name());
        }

        debug("有构造函数", "================");
        debug("获取枚举参数", SeasonOneParam.WINTER.getI());
        debug("获取枚举值", SeasonOneParam.WINTER);
        debug("valueOf(key)", SeasonOneParam.valueOf(1));
        debug("valueOf(name)", SeasonOneParam.valueOf("SPRING"));

        debug("有构造函数-带抽象方法", "================");
        debug("执行抽象方法", SeasonWithAbsFun.SUMMER.getName());
    }
    private static void debug(String prefix, Object str){
        System.out.printf("%30s", prefix + ":");
        System.out.println(str);
    }
}
enum Season{
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER
}
enum SeasonOneParam{
    SPRING(1),
    SUMMER(2),
    AUTUMN(3),
    WINTER(4);
    private int i;
    public int getI() {
        return i;
    }

    /**
     * 1、需要在枚举实例后面加上分号，然后再写构造函数等
     * 2、枚举实例必须在前面
     * 3、枚举中的所有构造方法都必须是private修饰，如果不加任何修饰符，默认就是private修饰。
     * @param i 自定义参数
     */
    SeasonOneParam(int i) {
        this.i = i;
    }
    /**
     * 根据value返回对应的枚举值
     * @param value
     * @return
     */
    public static SeasonOneParam valueOf(int value) {
        switch (value) {
            case 1: return SPRING;
            case 2: return SUMMER;
            case 3: return AUTUMN;
            case 4: return WINTER;
            default: return null;
        }
    }
}
enum SeasonWithAbsFun{
    SPRING(1) {
        @Override
        public String getName() {
            return "春天";
        }
    },
    SUMMER(2) {
        @Override
        public String getName() {
            return "夏天";
        }
    },
    AUTUMN(3) {
        @Override
        public String getName() {
            return "秋天";
        }
    },
    WINTER(4) {
        @Override
        public String getName() {
            return "冬天";
        }
    };
    public abstract String getName();
    private int i;
    public int getI() {
        return i;
    }

    /**
     * 1、需要在枚举实例后面加上分号，然后再写构造函数等
     * 2、枚举实例必须在前面
     * 3、枚举中的所有构造方法都必须是private修饰，如果不加任何修饰符，默认就是private修饰。
     * @param i 自定义参数
     */
    SeasonWithAbsFun(int i) {
        this.i = i;
    }
}
