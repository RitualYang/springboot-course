package com.wty.service;

import org.springframework.stereotype.Service;

/**
 * @author wty
 * @date 2020/8/31 17:09
 */
@Service
public class AutoConfigurationService {

    public String hello() {
        return "自动注入的service";
    }
}
