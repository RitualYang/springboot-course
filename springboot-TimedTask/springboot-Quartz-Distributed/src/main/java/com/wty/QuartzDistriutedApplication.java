package com.wty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.wty.mapper")
public class QuartzDistriutedApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuartzDistriutedApplication.class,args);
    }
}
