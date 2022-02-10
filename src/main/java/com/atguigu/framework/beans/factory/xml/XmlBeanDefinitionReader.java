package com.atguigu.framework.beans.factory.xml;

import com.atguigu.framework.beans.BeanDefinition;
import com.atguigu.framework.beans.MutablePropertyValues;
import com.atguigu.framework.beans.PropertyValue;
import com.atguigu.framework.beans.factory.support.BeanDefinitionReader;
import com.atguigu.framework.beans.factory.support.BeanDefinitionRegistry;
import com.atguigu.framework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @Classname XmlBeanDefinitionReader
 * @Description 针对xml配置文件进行解析的类
 * @Date 2022/2/9 21:29
 * @Author Administrator
 * @Version 1.0.0
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    /**
     * 声明注册表对象
     */
    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader() {
        registry = new SimpleBeanDefinitionRegistry();
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public void loadBeanDefinitions(String configLocation) throws Exception {
        SAXReader saxReader = new SAXReader();
        InputStream is = XmlBeanDefinitionReader.class.getClassLoader().getResourceAsStream(configLocation);
        Document document = saxReader.read(is);
        Element rootElement = document.getRootElement();
        List<Element> beanElements = rootElement.elements("bean");
        for (Element beanElement : beanElements) {
            BeanDefinition beanDefinition = new BeanDefinition();
            String id = beanElement.attributeValue("id");
            String className = beanElement.attributeValue("class");
            beanDefinition.setId(id);
            beanDefinition.setClassName(className);
            List<Element> propertyElements = beanElement.elements("property");
            MutablePropertyValues propertyValues = new MutablePropertyValues();
            for (Element property : propertyElements) {
                PropertyValue propertyValue = new PropertyValue();
                String name = property.attributeValue("name");
                String value = property.attributeValue("value");
                String ref = property.attributeValue("ref");
                propertyValue.setName(name);
                propertyValue.setValue(value);
                propertyValue.setRef(ref);
                propertyValues.addPropertyValue(propertyValue);
            }
            beanDefinition.setPropertyValues(propertyValues);
            registry.registerBeanDefinition(id, beanDefinition);
        }
    }
}
