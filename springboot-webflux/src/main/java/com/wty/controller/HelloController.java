package com.wty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author WTY
 * @Date 2020/8/19 21:58
 * @Description: TODO
 */
@RestController
@RequestMapping("/hello")
public class HelloController {


    @GetMapping("/mono")
    public Mono<String> mono(){
        return Mono.just("hello world");
    }
}
