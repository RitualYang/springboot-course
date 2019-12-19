package com.wty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author RitualYang
 * @create 2019-12-19 22:04
 */
@SpringBootApplication
@EntityScan(basePackages = "com.wty.model")
public class DataJPAApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataJPAApplication.class,args);
    }
}
