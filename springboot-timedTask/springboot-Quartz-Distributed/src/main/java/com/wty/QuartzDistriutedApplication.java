package com.wty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wty
 * @date 2020/8/24 23:13
 */
@SpringBootApplication
@MapperScan("com.wty.mapper")
public class QuartzDistriutedApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuartzDistriutedApplication.class, args);
    }
}
