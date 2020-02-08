package com.wty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author wty
 * @create 2020-02-08 19:25
 */
@SpringBootApplication
public class WarApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(WarApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WarApplication.class);
    }
}
