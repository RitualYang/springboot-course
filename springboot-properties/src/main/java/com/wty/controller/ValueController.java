package com.wty.controller;

import com.wty.model.GirlFriendConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author wty
 * @date 2020/02/08 21:14
 */
@RestController
@Slf4j
public class ValueController {
    @Value("${demo.phone}")
    private String phone;
    @Value("${demo.sex}")
    private String sex;
    @Value("${demo.address}")
    private String address;
    @Value("#{'${demo.identity}'.split(',')}")
    private List<String> identity;
    @Value("${demo.identity}")
    private String[] iden;
    //    @Value 无法获取 ‘-’ 指定的集合
//    @Value("${demo.cars}")
//    private List<String> cars;
    @Value("#{${demo.maps}}")
    private Map<String, String> maps;

    @Autowired
    private GirlFriendConfig girlFriendConfig;
//    @Value("${demo.girlfriend}")
//    private Girlfriend girlfriend;

    @RequestMapping(value = "value")
    public String getValue() {
        log.info("girlFriendConfig : {}",girlFriendConfig.getGirlfriendList());
        log.info("girlFriendConfig map : {}",girlFriendConfig.getMaps());
        return "phone : " + phone + " ; sex : " + sex + " ; address : " + address + " ; identity : " +
                identity.toString() + " ; maps : " + maps.toString();
//        +" ; girlfriend :" + girlfriend.toString();
    }
}
