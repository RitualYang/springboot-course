package com.wty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO
 *
 * @author wty
 * @Date 2020/8/31 15:48
 */
@Controller
@RequestMapping("/velocity")
public class VelocityController {

    @GetMapping("/velocityTest")
    public String velocityTest(){
        return null;

    }
}
