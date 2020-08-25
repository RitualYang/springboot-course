package com.wty.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wty
 * @Date 2019/05/12 17:55
 */
@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!!!!";
    }

}
