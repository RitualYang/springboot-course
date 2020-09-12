package com.wty.test;


import com.wty.entity.Class;
import com.wty.mapper.ClassMapper;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author wty
 * @Date 2020/01/04 23:10
 */
@SpringBootTest
@Slf4j
public class MybatisTest {

    @Autowired
    private ClassMapper classMapper;

    @Test
    public void select(){
        List<Class> classes = classMapper.selectAll();
        for (Class aClass : classes) {
            System.out.println(aClass.toString());
        }
    }


}
