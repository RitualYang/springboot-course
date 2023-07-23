package com.wty.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wty
 * @date 2019/05/12 17:55
 */
@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() throws InterruptedException {
        Thread.sleep(60000);
        return "Hello World!!!!";
    }

}
