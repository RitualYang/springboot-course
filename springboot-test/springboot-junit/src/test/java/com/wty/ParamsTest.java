package com.wty;

import com.wty.enums.TypeEnums;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@DisplayName("参数单元测试")
@SpringBootTest(classes = {JunitApplication.class})
@ActiveProfiles("test")
class ParamsTest {


    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"test","params"})
    void paramsTest(String params) {
        log.info("paramsTest params:{}", params);
    }

    @ParameterizedTest
    @NullSource
    @EnumSource(TypeEnums.class)
    void enumParamsTest(TypeEnums typeEnums) {
        log.info("enumParamsTest enums:{}", typeEnums);
    }

    @ParameterizedTest
    @CsvSource({
            "test,1",
            "params,2"
    })
    void csvParamsTest(String text, Integer num) {
        log.info("csvParamsTest text:{}, num:{}", text, num);
    }

}
