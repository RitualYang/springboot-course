package com.test;

import com.wty.mapper.UserInfoMapper;
import com.wty.mapper.UserMapper;
import com.wty.model.User;
import com.wty.model.UserInfo;
import com.wty.mybatisAnnotationApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author wty
 * @create 2020-01-04 23:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = mybatisAnnotationApplication.class)
@Slf4j
public class MybatisTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 一对一查询
     */
    @Test
    public void findOneForOne(){
        List<UserInfo> all = userInfoMapper.findAll();
        for (UserInfo userInfo : all) {
            log.info(userInfo.toString());
        }

    }

    /**
     * 一对多查询
     */
    @Test
    public void findOneForMany(){
        User one = userMapper.findOne(2);
        log.info(one.toString());// 如果userinfos没有被调用,mybatis不进行查询userinfo操作。
    }


}
