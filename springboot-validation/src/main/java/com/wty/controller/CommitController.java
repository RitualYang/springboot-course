package com.wty.controller;

import com.wty.model.R;
import com.wty.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
/**
 * @author WTY
 * @Date 2020/6/23 22:37
 */
@RestController
public class CommitController {

    @PostMapping("/register")
    public R register(@Valid User user){
        return R.ok("验证通过");
    }
}
