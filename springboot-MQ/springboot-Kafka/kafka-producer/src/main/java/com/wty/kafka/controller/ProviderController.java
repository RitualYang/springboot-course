package com.wty.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RitualYang
 * @create 2019-12-11 22:08
 */
@RestController
public class ProviderController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @RequestMapping(value = "send",method = RequestMethod.GET)
    public boolean send(String message){
        kafkaTemplate.send("testTopic",message);
        return true;
    }
}
