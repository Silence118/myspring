package com.atguigu.framework.context.support;

import com.atguigu.framework.beans.BeanDefinition;
import com.atguigu.framework.beans.MutablePropertyValues;
import com.atguigu.framework.beans.PropertyValue;
import com.atguigu.framework.beans.factory.support.BeanDefinitionRegistry;
import com.atguigu.framework.beans.factory.xml.XmlBeanDefinitionReader;
import com.atguigu.framework.utils.StringUtils;

import java.lang.reflect.Method;

/**
 * @Classname ClassPathXmlApplicationContext
 * @Description TODO
 * @Date 2022/2/10 10:49
 * @Author Administrator
 * @Version 1.0.0
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this.configLocation = configLocation;
        this.beanDefinitionReader = new XmlBeanDefinitionReader();
        this.refresh();
    }

    @Override
    public Object getBean(String name) throws Exception {
        //判断对象容器中是否包含指定名称的bean对象，如果包含直接返回，不包含自行创建。
        Object obj = singletonObjects.get(name);
        if (obj != null) {
            return obj;
        }

        //获取BeaDefinition对象
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        BeanDefinition beanDefinition = registry.getBeanDefinition(name);
        //获取bean信息中的className
        String className = beanDefinition.getClassName();
        Class<?> clazz = Class.forName(className);
        Object beanObj = clazz.newInstance();

        //依赖注入
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues) {
            String propertyName = propertyValue.getName();
            String value = propertyValue.getValue();
            String ref = propertyValue.getRef();
            if (ref != null && !"".equals(ref)) {
                Object bean = getBean(ref);
                //拼接方法名
                String methodName = StringUtils.getSetterMethodByFieldName(propertyName);
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (methodName.equals(method.getName())) {
                        method.invoke(beanObj, bean);
                    }
                }
            }
            if (value != null && !"".equals(value)) {
                String methodName = StringUtils.getSetterMethodByFieldName(propertyName);
                Method method = clazz.getMethod(methodName, String.class);
                method.invoke(beanObj, value);
            }
        }
        singletonObjects.put(name, beanObj);
        return beanObj;
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception {
        Object bean = getBean(name);
        if (bean == null) {
            return null;
        }
        return clazz.cast(bean);
    }
}
