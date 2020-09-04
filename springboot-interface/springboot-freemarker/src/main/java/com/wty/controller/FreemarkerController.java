package com.wty.controller;

import com.wty.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

/**
 * @author wty
 * @Date 2020/8/24 22:59
 * @Description: TODO
 */
@Controller
public class FreemarkerController {

    @GetMapping("/test")
    public String test(Model model) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId((long) i);
            user.setUsername("UserName>>>>" + i);
            user.setAddress("地址索引>>>>" + i);
            users.add(user);
        }
        model.addAttribute("users", users);
        return "test";
    }
}
