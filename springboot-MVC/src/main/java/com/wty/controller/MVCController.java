package com.wty.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wty
 * @Date 2020/6/23 22:55
 */
@RestController
@Slf4j
public class MVCController {

    @GetMapping("/testMvc")
    public String TestMvc(){
        log.info("执行请求");
        return "请求执行完毕";
    }

    @GetMapping("/testDate")
    public Map TestDate(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("date",new Date());
        return objectObjectHashMap;
    }
}
