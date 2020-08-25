package com.wty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wty
 * @Date 2019/05/12 17:51
 * 整个springboot服务启动工程入口
 * 注解解析：
 * @SpringBootApplication  :  Springboot项目的核心注解,主要目的开启自动配置.
 * @EnableAutoConfiguration   :  让Springboot项目根据默认配置路径为当前项目加载自动配置,配置默认名格式为application.yml(推荐)
 */
@SpringBootApplication
public class HelloWorldApplication {
    /**
     * 项目入口
     * @param args
     */
    public static void main(String[] args) {
        // 1.通过调用静态方法
        SpringApplication.run(HelloWorldApplication.class,args);

        // 2.通过api调整web启动模式
         /*SpringApplication application = new SpringApplication(HelloWorldApplication.class);
         application.setBannerMode(Banner.Mode.OFF);
         application.run(args);*/

        // 3. SpringApplicationBuilder Fluent Api,链式调用
        /*new SpringApplicationBuilder(HelloWorldApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);*/
    }
}
