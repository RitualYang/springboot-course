package com.ritualyang.controller;

import com.ritualyang.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author RitualYang
 * @create 2019-10-13 00:28
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setDate(new Date());
        user.setName("RitualYang");
        user.setPassword("123456");
        return user;
    }
}
