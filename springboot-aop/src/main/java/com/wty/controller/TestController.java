package com.wty.controller;

import com.wty.aop.TestApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author peter
 * @date 2022/9/5 15:26
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!!!!";
    }

    @TestApi
    @RequestMapping("/hello1")
    public String hello1() {
        return "Hello World!!!!";
    }

}
