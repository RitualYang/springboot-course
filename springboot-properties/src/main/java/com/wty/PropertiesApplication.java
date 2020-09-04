package com.wty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * application配置文件在Spring Boot中可以写在四个不同的位置，分别是如下位置(属性加载优先级顺序由高到低)：
 *  1. 项目根目录下的config目录中
 *  2. 项目根目录下
 *  3. classpath下的config目录中
 *  4. classpath目录下
 * 配置新位置可以通过:
 *      spring.config.location=xxx,xxx,xxx  # 会覆盖掉前4种位置
 *      spring.config.additional-location=xxx,xxx,xxx # 不会覆盖掉前4种位置,新加的位置优先级>原4种
 * @author wty
 * @Date 2020/02/08 20:44
 */
@SpringBootApplication
public class PropertiesApplication {
    public static void main(String[] args) {
        SpringApplication.run(PropertiesApplication.class,args);
    }
}
