package com.wty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * @author wty
 * @Date 2019/11/27 22:51
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @GetMapping("/Model")
    public String show(Model model){
        model.addAttribute("uid","123456");
        model.addAttribute("name","wty");
        return "Model";
    }
    @GetMapping("/ModelMap")
    public String index(ModelMap modelMap){
        modelMap.put("userName","wty");
        modelMap.put("date",new Date());
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("id",1);
        map1.put("name","张三");
        list.add(map1);
        Map<String,Object> map2 = new HashMap<>();
        map2.put("id",2);
        map2.put("name","李四");
        list.add(map2);
        modelMap.put("list", list);
        return "ModelMap";
    }

}
