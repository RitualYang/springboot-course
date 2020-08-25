package com.wty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 修改内置tomcat的服务配置
 * @author wty
 * @Date 2020/8/19 09:46
 * @Description: 启动类
 */
@SpringBootApplication
public class TomcatApplication {
    public static void main(String[] args) {
        SpringApplication.run(TomcatApplication.class,args);
    }
}
