package com.wty.util;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * es工具
 *
 * @author wty
 * @date 2021/8/16 16:23
 */
@Component
@Slf4j
public class EsHelper {
    @Autowired
    private RestHighLevelClient client;

    public void createIndex(String indexName) {
        try{
            CreateIndexRequest request = new CreateIndexRequest(indexName);
            request.settings(Settings.builder()
                    .put("index.number_of_shards", 1)
                    .put("index.number_of_replicas", 0)
            );
            client.indices().create(request, RequestOptions.DEFAULT);
            log.info("索引创建成功");
        }catch (Exception e){
            log.error("索引创建失败:{}", e.getMessage());
        }
    }

    public void createIndex(String indexName, String settings, String mappings) {
        try{
            CreateIndexRequest request = new CreateIndexRequest(indexName);
            buildSetting(request, settings);
            buildIndexMapping(request, mappings);
            client.indices().create(request, RequestOptions.DEFAULT);
            log.info("索引创建成功");
        }catch (Exception e){
            log.error("索引创建失败:{}", e.getMessage());
        }
    }
    /**
     * 设置分片
     * @param request
     */
    private void buildSetting(CreateIndexRequest request, String settings) {
        request.settings(settings, XContentType.JSON);
    }

    /**
     * 设置索引的mapping
     * @param request
     */
    private void buildIndexMapping(CreateIndexRequest request, String mappings) {
        request.mapping(mappings, XContentType.JSON);
    }

    /**
     *
     * @param indexName
     * @return
     */
    public boolean existsIndex(String indexName) {
        try{
            GetIndexRequest request = new GetIndexRequest(indexName);
            return client.indices().exists(request, RequestOptions.DEFAULT);
        }catch (Exception e){
            log.error("未知错误:{}", e.getMessage());
        }
        return false;
    }
}
