package com.wty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wty
 * @date 2020/11/3 10:27
 */
@Slf4j
@SpringBootApplication
public class LogbackApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);

        log.info("application up info");
        log.warn("application up warn");
        log.error("application up error");
    }
}
