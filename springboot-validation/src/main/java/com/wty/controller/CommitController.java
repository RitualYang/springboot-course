package com.wty.controller;

import com.wty.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author WTY
 * @Date 2020/6/23 22:37
 */
@RestController
public class CommitController {

    @PostMapping("/register")
    public Map register(@Valid User user, BindingResult result){
        Map map = new HashMap();
        if (result.hasErrors()) {
            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            return errors;

        }
        map.put("message","信息校验正确");
        return map;
    }
}
