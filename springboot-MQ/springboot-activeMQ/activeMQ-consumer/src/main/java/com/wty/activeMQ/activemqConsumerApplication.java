package com.wty.activeMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class activemqConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(activemqConsumerApplication.class,args);
    }
}
