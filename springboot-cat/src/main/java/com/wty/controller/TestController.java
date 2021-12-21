package com.wty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author wty
 * @date 2021/10/22 16:11
 * 描述:
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/get")
    public String get() {
        return "get over";
    }
    @GetMapping("/get/{id}")
    public String getId(@PathVariable String id) {
        return "get over" + id;
    }

    @GetMapping("/getError/{id}")
    public String getErrorId(@PathVariable String id) {
        int i = 10 / (new Random().nextInt() % 2);
        return "get error over" + id;
    }

    @GetMapping("/getError")
    public String getError() {
        int i = 10 / (new Random().nextInt() % 2);
        return "get error over";
    }
}
