package com.wty;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TODO
 *
 * @author wty
 * @date 2020/12/15 13:42
 */
@Slf4j
@DisplayName("单元测试")
@SpringBootTest(classes = {JunitApplication.class})
public class JunitTest {

    @Test
    public void contextLoad(){}

    @BeforeAll
    public static void init(){
        log.info("初始化");
    }

    @AfterAll
    public static void cleanup(){
        log.info("清理连接,销毁对象");
    }

    @BeforeEach
    public void create(){

    }
    @AfterEach
    public void destroy(){

    }
    @Test
    @DisplayName("测试方法")
    public void test(){
        log.info("执行测试方法");
    }

}
