package com.xiaomi.cloudservicea.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DiamondBean
 * @author: xiaomi
 * @Description: //TODO
 * @Time: 2019/8/13 0013 下午 4:31
 * @email: a1205938863@gmail.com
 */
@Component
@ConfigurationProperties(prefix = "xiaomi")
public class DiamondBean {
    private String name="xiaomi123";
    private Integer age=333;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
