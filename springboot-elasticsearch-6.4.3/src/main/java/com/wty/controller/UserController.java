package com.wty.controller;

import com.wty.model.User;
import com.wty.repository.UserRepository;
import org.assertj.core.util.Lists;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @author RitualYang
 * @create 2019-12-24 12:12
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("save")
    @ResponseBody
    public String save(){

        User user = new User();
        user.setId(995L);
        user.setAge(19L);
        user.setUsername("wty");
        user.setPassword("123456");
        user.setMobile("123456789");
        user.setEmail("XXXXXXXX@qq.com");
        userRepository.save(user);
        return "保持成功";
    }

    @GetMapping("search")
    public String search(){

        //按标题进行搜索
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("username", "wty");

        //如果实体和数据的名称对应就会自动封装，pageable分页参数
        Iterable<User> users = userRepository.search(queryBuilder);

        //Iterable转list
        ArrayList<User> users1 = Lists.newArrayList(users);

        return users1.toString();
    }

}
