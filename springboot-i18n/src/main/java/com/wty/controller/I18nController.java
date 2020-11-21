package com.wty.controller;

import com.wty.constant.MessageConstant;
import com.wty.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wty
 * @date 2020/5/30 21:52
 */
@RestController
@RequestMapping("/i18n")
public class I18nController {

    @Autowired
    private MessageUtils messageUtils;

    /**
     * http://localhost:8080/i18n/testLang?lang=zh_CN
     * http://localhost:8080/i18n/testLang?lang=en_US
     *
     * @return
     */
    @GetMapping("/testLang")
    public String testLang() {
        System.out.println(MessageConstant.USERNAME);
        return messageUtils.get(MessageConstant.USERNAME);
    }
}
