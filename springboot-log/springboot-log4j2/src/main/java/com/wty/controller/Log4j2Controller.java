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
 * @Date 2020/11/3 10:49
 */
@RestController
@RequestMapping("/log4j2")
public class Log4j2Controller {

    private static final Logger log = LoggerFactory.getLogger(Log4j2Controller.class);

    @GetMapping("/print")
    public String print(){
        log.info("info massage");
        log.warn("warn massage");
        log.error("error massage");
        return "print ok!";
    }

}
