package com.atguigu.framework.context.support;

import com.atguigu.framework.beans.factory.support.BeanDefinitionReader;
import com.atguigu.framework.beans.factory.support.BeanDefinitionRegistry;
import com.atguigu.framework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname AbstractApplicationContext
 * @Description TODO
 * @Date 2022/2/10 10:37
 * @Author Administrator
 * @Version 1.0.0
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    /**
     * 声明解析器对象
     */
    protected BeanDefinitionReader beanDefinitionReader;

    /**
     * 定义存储bean对象的map容器
     */
    protected Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 声明配置文件路径的变量
     */
    protected String configLocation;

    @Override
    public void refresh() throws Exception {
        //加载BeanDefinition对象
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        //初始化bean
        finishBeanInitialization();
    }

    /**
     * bean的初始化
     * @throws Exception 异常
     */
    private void finishBeanInitialization() throws Exception {
        //获取注册表对象
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();

        //获取BeanDefinition对象
        String[] beanNames = registry.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            getBean(beanName);
        }
    }
}
