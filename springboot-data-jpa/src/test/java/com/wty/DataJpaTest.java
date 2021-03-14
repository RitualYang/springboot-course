package com.wty;

import com.wty.entity.Class;
import com.wty.mapper.ClassMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author wty
 * @date 2020/9/15 20:29
 */
@SpringBootTest
public class DataJpaTest {

    @Autowired
    private ClassMapper classMapper;
    @Test
    public void contextLoad(){}

    @Test
    public void test() {
        List<Class> all = classMapper.findAll();
        System.out.println(all);
    }
}
