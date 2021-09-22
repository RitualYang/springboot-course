package com.wty.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wty
 * @date 2019/11/21 20:30
 */
@RestController
public class LoginController {

    @GetMapping("/hello")
    public String hello() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        return "hello world";
    }

    @GetMapping("/code")
    public String code() {
        return "123";
    }

}
