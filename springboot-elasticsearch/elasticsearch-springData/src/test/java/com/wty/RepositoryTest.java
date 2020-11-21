package com.wty;

import com.wty.model.User;
import com.wty.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.ccr.FollowInfoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
