package com.wty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author RitualYang
 * @create 2019-11-01 16:59
 */
@SpringBootApplication
@MapperScan("com.wty.mapper")
public class mybatisXmlApplication {
    public static void main(String[] args) {
        SpringApplication.run(mybatisXmlApplication.class,args);
    }
}
