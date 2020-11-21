package com.wty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * webflux测试接口
 *
 * @author wty
 * @date 2020/8/19 21:58
 */
@RestController
@RequestMapping("/webflux")
public class WebfluxController {

    @GetMapping("/mono")
    public Mono<String> mono() {
        return Mono.just("hello world");
    }
}
