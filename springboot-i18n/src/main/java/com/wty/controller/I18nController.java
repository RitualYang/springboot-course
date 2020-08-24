package com.wty.controller;

import com.wty.constant.I18nConstant;
import com.wty.constant.MessageConstant;
import com.wty.utils.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WTY
 * @Date 2020/5/30 21:52
 */
@RestController
@RequestMapping("/i18n")
public class I18nController {

    @Autowired
    private MessageUtils messageUtils;

    @GetMapping("/testLang")
    public String testLang(){
        System.out.println(I18nConstant.USERNAME.getKey());
        return messageUtils.get(MessageConstant.USERNAME);
    }
}
