package com.wty.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wty.entity.Class;
import com.wty.mapper.ClassMapper;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author wty
 * @date 2020/01/04 23:10
 */
@SpringBootTest
@Slf4j
public class MybatisTest {

    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Autowired
    private ClassMapper classMapper;

    @Test
    public void select() {
        Long aLong = classMapper.selectLong();
        System.out.println(aLong);
        Class aClass = new Class();
        aClass.setDDD(aLong);
        Map map = OBJECT_MAPPER.convertValue(aClass, Map.class);
        System.out.println(map.toString());
//        List<Class> classes = classMapper.selectAll();
//        for (Class aClass : classes) {
//            System.out.println(aClass.toString());
//        }
    }

}
