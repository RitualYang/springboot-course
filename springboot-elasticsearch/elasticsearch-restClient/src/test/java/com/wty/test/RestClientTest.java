package com.wty.test;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wty
 * @date 2020/8/25 22:02
 */
@SpringBootTest
public class RestClientTest {

    @Autowired
    private RestHighLevelClient esRestClient;

    @Test
    public void contextLoads() {
        System.out.println(esRestClient);
    }

    /**
     * TODO：保存数据
     */
    @Test
    public void indexData() {

    }
    /**
     * TODO：查询数据
     */
}
