package com.wty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wty
 * @create 2020-02-08 21:18
 */
@RestController
public class EnvironmentController {
    @Autowired
    private Environment environment;

    @RequestMapping(value = "environment")
    public String getEnvironment() {
        return "phone : " + environment.getProperty("demo.phone") + " ; sex : " + environment.getProperty("demo.sex") + " ; address : " + environment.getProperty("demo.address");
    }
}
