package com.atguigu.framework.beans.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Classname MutablePropertyValues
 * @Description 用户存储和管理多个PropertyValue对象
 * @Date 2022/2/8 20:38
 * @Author Administrator
 * @Version 1.0.0
 */
public class MutablePropertyValues implements Iterable<PropertyValue> {

    /**
     * 定义list集合对象，用来存储PropertyValue对象
     */
    private final List<PropertyValue> propertyValueList;

    public MutablePropertyValues() {
        this.propertyValueList = new ArrayList<>();
    }

    public MutablePropertyValues(List<PropertyValue> propertyValueList) {
        if (propertyValueList == null) {
            this.propertyValueList = new ArrayList<>();
        } else {
            this.propertyValueList = propertyValueList;
        }
    }

    /**
     * 获取所有的PropertyValue对象，以数组的形式返回
     */
    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据name属性值获取PropertyValue对象
     */
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }

    /**
     * 判断集合是否为空
     *
     * @return 集合是否为空
     */
    public boolean isEmpty() {
        return propertyValueList.isEmpty();
    }

    /**
     * 添加PropertyValue对象
     *
     * @param propertyValue 待添加的PropertyValue对象
     * @return MutablePropertyValues对象
     */
    public MutablePropertyValues addPropertyValue(PropertyValue propertyValue) {
        for (PropertyValue currentPv : propertyValueList) {
            if (currentPv.getName().equals(propertyValue.getName())) {
                currentPv.setName(propertyValue.getName());
                return this;
            }
        }
        propertyValueList.add(propertyValue);
        //目的是实现链式编程
        return this;
    }

    /**
     * 判断是否有指定name属性的对象
     *
     * @param propertyName 属性名
     * @return 是否包含属性值的对象
     */
    public boolean contains(String propertyName) {
        return getPropertyValue(propertyName) != null;
    }

    /**
     * 获取迭代器对象
     */
    @Override
    public Iterator<PropertyValue> iterator() {
        return this.propertyValueList.iterator();
    }


}
