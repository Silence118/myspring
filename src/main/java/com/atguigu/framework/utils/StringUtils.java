package com.atguigu.framework.utils;

/**
 * @Classname StringUtils
 * @Description TODO
 * @Date 2022/2/10 11:00
 * @Author Administrator
 * @Version 1.0.0
 */
public class StringUtils {
    private StringUtils() {
    }

    /**
     * userDao ==> setUserDao
     */
    public static String getSetterMethodByFieldName(String fieldName) {
        return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }
}
