package com.wty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wty
 * @date 2019/11/01 16:59
 */
@SpringBootApplication
@MapperScan("com.wty.mapper")
public class MybatisXmlApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisXmlApplication.class, args);
    }
}
