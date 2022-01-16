package com.wty.es;

import com.wty.ElasticsearchClientApplication;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * springData测试
 *
 * @author wty
 * @date 2020/12/24 21:51
 */
@SpringBootTest(classes = {ElasticsearchClientApplication.class})
public class ClientTest {

    @Resource
    private RestHighLevelClient client;
    @Test
    public void contextLoad(){}

    @Test
    public void searchHigh() throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        BoolQueryBuilder orQuery = QueryBuilders.boolQuery();
        String suppliment = "";
        String text = "漂亮的妹妹";
        boolQueryBuilder.must(QueryBuilders.multiMatchQuery(text + ((suppliment == "") ? "" : (" " + suppliment)), "title", "content"));

        searchSourceBuilder.query(boolQueryBuilder);

        // 4.结果高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.requireFieldMatch(true); // 如果该属性中有多个关键字 则都高亮
        highlightBuilder.field("title");
        highlightBuilder.field("content");
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");

        searchSourceBuilder.highlighter(highlightBuilder);
        SearchRequest searchRequest = new SearchRequest("test_user");
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(50);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits searchHit = response.getHits();

        Long allRow = searchHit.getTotalHits().value;
        convertSearchHitsToList(searchHit);
    }

    private void convertSearchHitsToList(SearchHits searchHit) {
        SearchHit[] hits = searchHit.getHits();
        for (SearchHit hit : hits) {
            // 解析高亮字段
            // 获取当前命中的对象的高亮的字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            for (String key : highlightFields.keySet()) {
                if ("title".equals(key))
                    continue;
                HighlightField value = highlightFields.get(key);
                if (value != null) {
                    String newName = "";
                    // 获取该高亮字段的高亮信息
                    Text[] fragments = value.getFragments();
                    // 将前缀、关键词、后缀进行拼接
                    for (Text fragment : fragments) {
                        newName += fragment;
                    }
                    Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                    // 将高亮后的值替换掉旧值
                    sourceAsMap.put(key, newName);
                }
            }
        }
    }
}
