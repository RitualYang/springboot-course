package com.wty.controller;

import com.wty.service.AutoConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wty
 * @date 2020/8/31 17:15
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private AutoConfigurationService autoConfigurationService;

    @GetMapping("/test")
    public String test() {
        return autoConfigurationService.hello();
    }
}
