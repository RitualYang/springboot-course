package com.wty.controller;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author WTY
 * @Date 2020/8/25 21:59
 */
@RestController
@RequestMapping("/es")
public class RestClientController {

    @Autowired
    private RestHighLevelClient esRestClient;

}
