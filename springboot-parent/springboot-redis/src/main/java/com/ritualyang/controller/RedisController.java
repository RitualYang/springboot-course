package com.ritualyang.controller;

import com.ritualyang.service.RedisServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RitualYang
 * @create 2019-11-01 21:08
 */
@RestController
public class RedisController {

    @Autowired
    private RedisServiceImp redisServiceImp;

    @RequestMapping(value = "/set",method = RequestMethod.GET)
    public String setValue(){

        return redisServiceImp.setMsg("msg","123456");
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String getValue(){
        return redisServiceImp.getMsg("msg");
    }
}
