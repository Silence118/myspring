package com.atguigu.framework.beans.factory.support;

import com.atguigu.framework.beans.BeanDefinition;

/**
 * @Classname BeanDefinitionRegistry
 * @Description 注册表对象
 * @Date 2022/2/8 21:13
 * @Author Administrator
 * @Version 1.0.0
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册BeanDefinition对象到注册表中
     *
     * @param beanName       bean名称
     * @param beanDefinition beanDefinition对象
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 从注册表中删除指定名称的BeanDefinition对象
     *
     * @param beanName bean名称
     * @throws Exception 异常
     */
    void removeBeanDefinition(String beanName) throws Exception;

    /**
     * 根据名称从注册表中获取BeanDefinition对象
     *
     * @param beanName bean名称
     * @return beanDefinition对象
     * @throws Exception 异常
     */
    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    /**
     * 判断是否包含指定名称的bean
     *
     * @param beanName bean名称
     * @return 是否包含
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 获取注册的bean的数量
     *
     * @return 注册的bean的数量
     */
    int getBeanDefinitionCount();

    /**
     * 获取所有的bean名称
     *
     * @return 所有的bean名称
     */
    String[] getBeanDefinitionNames();
}
