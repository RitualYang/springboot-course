package com.wty.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WTY
 * @Date 2020/6/23 22:55
 */
@RestController
@Slf4j
public class MVCController {

    @GetMapping("/testmvc")
    public String TestMvc(){
        log.info("执行请求");
        return "请求执行完毕";
    }
}
