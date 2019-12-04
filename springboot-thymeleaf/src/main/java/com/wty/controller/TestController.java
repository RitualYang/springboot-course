package com.wty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * @author RitualYang
 * @create 2019-11-27 22:51
 */
@Controller
public class TestController {

    @RequestMapping(value = "Model", method = RequestMethod.GET)
    public String show(Model model){
        model.addAttribute("uid","123456");
        model.addAttribute("name","RitualYang");
        return "Model";
    }
    @RequestMapping(value = "ModelMap", method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.put("userName","RitualYang");
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
