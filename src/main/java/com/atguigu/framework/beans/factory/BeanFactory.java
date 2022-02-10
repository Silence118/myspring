package com.atguigu.framework.beans.factory;

/**
 * @Classname BeanFactory
 * @Description TODO
 * @Date 2022/2/10 10:07
 * @Author Administrator
 * @Version 1.0.0
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    <T> T getBean(String name, Class<? extends T> clazz) throws Exception;
}
