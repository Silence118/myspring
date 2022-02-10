package com.atguigu.framework.context;

import com.atguigu.framework.beans.factory.BeanFactory;

/**
 * @Classname ApplicationContext
 * @Description TODO
 * @Date 2022/2/10 10:09
 * @Author Administrator
 * @Version 1.0.0
 */
public interface ApplicationContext extends BeanFactory {

    void refresh() throws Exception;

}
