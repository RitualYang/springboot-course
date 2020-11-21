package com.wty;

import com.wty.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;

/**
 * @author wty
 * @date 2020/11/20 21:49
 */
@SpringBootTest(classes = ElasticsearchDataApplication.class)
public class TemplateTest {
    @Autowired
    public ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void loading() {
        System.out.println(elasticsearchRestTemplate);
    }

    @Test
    public void save() {
        User user = new User();
        user.setId(101L);
        user.setUsername("wty101");
        user.setPassword("12345678");
        user.setAge(100L);
        user.setMobile("12345566");
        user.setEmail("xxxxxx@qq.com");
        elasticsearchRestTemplate.save(user);
    }

    @Test
    public void delete() {
        elasticsearchRestTemplate.delete("101", User.class);
    }

    @Test
    public void update() {
        User user = elasticsearchRestTemplate.get("101", User.class);
        user.setUsername("RitualYang");
        elasticsearchRestTemplate.save(user);
    }

    @Test
    public void queryPage() {
        PageRequest of = PageRequest.of(1, 10);
        Query query = new CriteriaQuery(new Criteria(), of);
        SearchHits<User> search = elasticsearchRestTemplate.search(query, User.class);
        System.out.println(search.getTotalHits());
        System.out.println(search.getMaxScore());
        search.getSearchHits().stream().forEach(user -> {
            System.out.println(user.getContent());
        });
    }
}
