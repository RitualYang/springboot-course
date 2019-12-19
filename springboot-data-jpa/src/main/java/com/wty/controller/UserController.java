package com.wty.controller;

import com.wty.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RitualYang
 * @create 2019-12-19 22:20
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "name",method = RequestMethod.GET)
    public String getUser(){
        return userService.getUserByName("root").toString();
    }
}
