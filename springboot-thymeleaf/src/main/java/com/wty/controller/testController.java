package com.wty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author RitualYang
 * @create 2019-11-27 22:51
 */
@Controller
public class testController {

    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String show(Model model){
        model.addAttribute("uid","123456");
        model.addAttribute("name","RitualYang");
        return "show";
    }

}
