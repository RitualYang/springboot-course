package com.ritualyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author RitualYang
 * @create 2019-05-12 17:51
 * 整个springboot服务启动工程入口
 * 注解解析：
 * @SpringBootApplication  :  Springboot项目的核心注解，主要目的开启自动配置.
 *   @EnableAutoConfiguration   :让Springboot项目根据默认配置路径为当前项目加载自动配置,配置默认名格式为application.yml(推荐)
 */
@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HelloApplication {
    //项目入口
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class);
    }
}
