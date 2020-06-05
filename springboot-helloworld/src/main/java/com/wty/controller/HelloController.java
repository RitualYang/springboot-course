package com.wty.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wty.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.Date;

/**
 * @author wty
 * @create 2019-05-12 17:55
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private ObjectMapper mapper;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!!!!";
    }

    @GetMapping("/jackson")
    public Person jackson() throws Exception {
        Person person = Person.builder()
                .name("wty")
                .age(20)
                .address("xinxiang")
                .registerTime(new Date())
                .build();
        String jsonPerson = mapper.writeValueAsString(person);
        log.info("person jackson: {}",jsonPerson);
        return mapper.readValue(jsonPerson,Person.class);
    }

}
