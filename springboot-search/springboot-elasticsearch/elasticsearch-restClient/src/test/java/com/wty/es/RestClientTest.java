package com.wty.es;

import com.alibaba.fastjson.JSON;
import com.wty.model.EsUser;
import com.wty.util.EsHelper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wty
 * @date 2020/8/25 22:02
 */
@SpringBootTest
@Slf4j
public class RestClientTest {

    @Autowired
    private RestHighLevelClient esRestClient;
    @Autowired
    private EsHelper esHelper;

    private String indexName;


    @Test
    public void contextLoads() {
        System.out.println(esRestClient);
    }

    @BeforeEach
    public void before() {
        indexName = "test_user";
        if (!esHelper.existsIndex(indexName)) {
            esHelper.createIndex(indexName);
        }
    }

    @Test
    public void saveData() {
        EsUser esUser = new EsUser();
        esUser.setUserName("世道");
        esUser.setAge(32);
        esUser.setGander(true);
        esUser.setId(1L);
        try{
            IndexRequest request = new IndexRequest("post");
            request.index(indexName).id(String.valueOf(esUser.getId())).source(esUser, XContentType.JSON);
            IndexResponse response = esRestClient.index(request, RequestOptions.DEFAULT);
            log.info("es 索引新增成功");
            System.out.println(JSON.toJSONString(response));
        }catch (Exception e){
            log.error("索引数据变更失败:{}", e.getMessage());
        }
    }

    @Test
    public void getData() {

    }
}
