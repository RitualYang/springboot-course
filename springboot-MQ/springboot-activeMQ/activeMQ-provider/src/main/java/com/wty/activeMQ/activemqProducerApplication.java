package com.wty.activeMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class activemqProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(activemqProducerApplication.class,args);
    }
}
