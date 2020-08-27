package com.wty.test;

import com.alibaba.fastjson.JSON;
import com.wty.model.EsUser;
import net.minidev.json.JSONArray;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TODO
 *
 * @author wty
 * @Date 2020/8/25 22:02
 */
@SpringBootTest
public class RestClientTest {

    @Autowired
    private RestHighLevelClient esRestClient;

    @Test
    public void contextLoads(){
        System.out.println(esRestClient);
    }

    @Test
    public void indexData(){
        IndexRequest indexRequest = new IndexRequest("es");
        indexRequest.id("1");
        /*indexRequest.source("userName","admin", "age",18, "gander","男");*/
        EsUser esUser = new EsUser("admin",18,"男");
        String jsonString = JSON.toJSONString(esUser);
        indexRequest.source(jsonString);


    }
}
