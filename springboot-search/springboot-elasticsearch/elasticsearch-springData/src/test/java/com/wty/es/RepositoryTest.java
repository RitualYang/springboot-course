package com.wty.es;

import com.wty.ElasticsearchDataApplication;
import com.wty.model.User;
import com.wty.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wty
 * @date 2020/11/20 21:38
 */
@SpringBootTest(classes = {ElasticsearchDataApplication.class})
@Slf4j
public class RepositoryTest {
    @Autowired
    private UserRepository userRepository;


    @Test
    public void loading() {
        System.out.println(userRepository);
    }

    @Test
    public void save() {
        ArrayList<User> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setId(Long.valueOf(i));
            user.setAge(Long.valueOf(i + 15));
            user.setUsername("wty" + i);
            user.setPassword("123456");
            user.setMobile("123456789");
            user.setEmail("XXXXXXXX@qq.com");
            user.setTitle("美丽的妹妹"+i);
            user.setContent("在当前目录下通过文件名查找一个文件，使用类似于这样的命令：`find . -iname '*something*'`。在所有路径下通过文件名查找文件，使用 `locate something` （但注意到 `updatedb` 可能没有对最近新建的文件建立索引，所以你可能无法定位到这些未被索引的文件）。");
            arrayList.add(user);
        }
        userRepository.saveAll(arrayList);
        log.info("保存生成");
    }

    @Test
    public void search() {
        List<User> wt1 = userRepository.queryUsersByUsernameLike("wt");
        System.out.println("query");
        for (User user : wt1) {
            System.out.println(user);
        }
        List<User> wt = userRepository.findUsersByUsername("wty1");
        System.out.println("find");
        for (User user : wt) {
            System.out.println(user);
        }
        log.info("搜索完成");
    }
}
