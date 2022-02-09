package com.atguigu.framework.beans.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname PropertyValue
 * @Description TODO
 * @Date 2022/2/8 20:35
 * @Author Administrator
 * @Version 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyValue {
    private String name;
    private String value;
    private String ref;
}
