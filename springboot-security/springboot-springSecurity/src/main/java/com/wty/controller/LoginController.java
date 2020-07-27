package com.wty.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wty
 * @create 2019-11-21 20:30
 */
@Controller
public class LoginController {
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @RequestMapping("/login")
    public String login(){
        return "/templates/login.html";
    }

}
