package com.wty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * velocity测试接口
 *
 * @author wty
 * @date 2020/8/31 15:48
 */
@Controller
@RequestMapping("/velocity")
public class VelocityController {

    @GetMapping("/velocityTest")
    public String velocityTest() {
        return null;

    }
}
