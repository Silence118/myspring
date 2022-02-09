package com.atguigu.framework.beans.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname BeanDefinition
 * @Description TODO
 * @Date 2022/2/8 21:07
 * @Author Administrator
 * @Version 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeanDefinition {
    private String id;
    private String className;

    private MutablePropertyValues propertyValues;


}
