package com.wty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wty
 * @date 2020/02/08 21:18
 */
@RestController
public class EnvironmentController {
    @Autowired
    private Environment environment;

    @GetMapping("/environment")
    public String getEnvironment() {
        return "phone : " + environment.getProperty("demo.phone") +
                " ; sex : " + environment.getProperty("demo.sex") +
                " ; address : " + environment.getProperty("demo.address") +
                " ; identity : " + environment.getProperty("demo.identity").toString() +
//                " ; cars : " + environment.getProperty("demo.cars").toString() +
                " ; maps : " + environment.getProperty("demo.maps").toString();
//                + " ; girlfriend :" + environment.getProperty("demo.girlfriend").toString();
    }
}
