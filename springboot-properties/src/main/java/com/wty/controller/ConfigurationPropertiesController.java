package com.wty.controller;

import com.wty.model.Girlfriend;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @author wty
 * @create 2020-02-08 21:21
 */
@RestController
@ConfigurationProperties(prefix = "demo")// 需要属性有set方法
@Data
public class ConfigurationPropertiesController {
    private String phone;
    private String sex;
    private String address;
    private List<String> identity;
    private List<String> cars;
//    private Map<String,String> maps;
    private Girlfriend girlfriend;

    @RequestMapping(value = "properties")
    public String getProperties(){
        return "phone : " + phone + " ; sex : " + sex + " ; address : " + address + " ; identity : " +
                identity.toString() + " ; cars : " + cars.toString() + " ; maps : " + " ; girlfriend :"
                + girlfriend.toString();
    }
}
