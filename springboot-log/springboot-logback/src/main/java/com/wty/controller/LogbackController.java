package com.wty.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author wty
 * @Date 2020/11/3 11:01
 */
@RestController
@RequestMapping("/logback")
public class LogbackController {
    private static final Logger log = LoggerFactory.getLogger(LogbackController.class);

    @GetMapping("/print")
    public String print(){
        log.info("info massage");
        log.warn("warn massage");
        log.error("error massage");
        return "print ok!";
    }
}
