package com.wty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https测试接口
 *
 * @author wty
 * @date 2020/9/4 09:46
 */
@RestController
@RequestMapping("/https")
public class HttpsController {

    @GetMapping("/getInfo")
    public String getInfo() {
        return "测试https协议接口成功";
    }
}
