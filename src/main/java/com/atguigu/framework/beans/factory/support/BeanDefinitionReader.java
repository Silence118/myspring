package com.atguigu.framework.beans.factory.support;

/**
 * @Classname BeanDefinitionReader
 * @Description TODO
 * @Date 2022/2/9 21:14
 * @Author Administrator
 * @Version 1.0.0
 */
public interface BeanDefinitionReader {
    /**
     * 获取注册表对象
     *
     * @return 注册表对象
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 加载配置文件并在注册表中注册
     *
     * @param configLocation 配置文件的位置
     * @throws Exception 异常
     */
    void loadBeanDefinitions(String configLocation) throws Exception;
}
