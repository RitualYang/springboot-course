package com.wty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * TODO
 *
 * @author WTY
 * @Date 2020/8/26 16:39
 */
@SpringBootApplication
@EnableAsync
public class NettyApplication {
    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class,args);
    }
}
