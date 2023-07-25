package com.wty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * 单元测试
 *
 * @author wty
 * @date 2020/12/15 13:42
 */
@Slf4j
@DisplayName("单元测试")
@SpringBootTest(classes = {JunitApplication.class})
@ActiveProfiles("test")
class JunitTest {

    @Test
    void contextLoad() {
        log.info("内容加载");
    }

    @BeforeAll
    static void init() {
        log.info("初始化");
    }

    @AfterAll
    static void cleanup() {
        log.info("清理连接,销毁对象");
    }

    @BeforeEach
    void create() {
        log.info("创建");
    }

    @AfterEach
    void destroy() {
        log.info("摧毁");
    }

    @Test
    @DisplayName("测试方法")
    void test() {
        log.info("执行测试方法");
    }

    /**
     * 重复测试
     */
    @RepeatedTest(5)
    void repeatedTest() {
        log.info("repeatedTest");
    }

    @Test
    void assertThrowsTest() {
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
            int i = 100 / 0;
        });
        assertEquals("/ by zero", exception.getMessage());
    }

}
