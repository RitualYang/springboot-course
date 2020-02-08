package com.wty.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wty
 * @create 2020-02-08 21:14
 */
@RestController
public class ValueController {
    @Value("${demo.phone}")
    private String phone;
    @Value("${demo.sex}")
    private String sex;
    @Value("${demo.address}")
    private String address;

    @RequestMapping(value = "value")
    public String getValue(){
        return "phone : " + phone + " ; sex : " + sex + " ; address : " + address;
    }
}
