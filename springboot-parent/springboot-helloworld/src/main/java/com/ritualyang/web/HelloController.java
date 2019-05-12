package com.ritualyang.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RitualYang
 * @create 2019-05-12 17:55
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!!!!";
    }

}
