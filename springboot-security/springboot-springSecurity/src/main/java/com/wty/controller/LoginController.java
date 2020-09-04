package com.wty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wty
 * @Date 2019/11/21 20:30
 */
@RestController
public class LoginController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

}
