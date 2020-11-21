package com.wty.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author wty
 */
@SpringBootApplication
@EnableJms
public class ActivemqConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActivemqConsumerApplication.class, args);
    }
}
