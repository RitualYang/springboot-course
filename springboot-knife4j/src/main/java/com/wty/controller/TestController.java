package com.wty.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author wty
 * @Date 2020/9/3 09:58
 */
@Api(value = "测试",tags = "测试用例")
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/getInfo")
    @ApiOperation(value = "getInfo",notes = "获取服务信息")
    public String getInfo(){
        return "这是Knife4j-service";
    }
}
