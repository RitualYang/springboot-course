package com.wty;

import com.wty.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

/**
 * 可解决单元测试时,避免启动redis,mysql,dubbo,elasticsearch等中间件
 */
@Slf4j
@DisplayName("mock测试")
@SpringBootTest(classes = {JunitApplication.class})
@ActiveProfiles("test")
class MockTest {

    @MockBean
    private TestService mockTestService;

    @Test
    void mockServiceTest() {
        mockTestService.testMock();
        log.info(mockTestService.toString());
    }
}
