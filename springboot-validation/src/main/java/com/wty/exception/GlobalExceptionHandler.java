package com.wty.exception;

import com.wty.model.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 参数校验拦截
 * @author Administrator
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 方法参数校验异常
     */
    @ExceptionHandler(BindException.class)
    public R handleBindException(BindException e) {
        log.info("参数校验失败");
        new HashMap<String,String>(8);

        List<String> collect = e.getBindingResult().getAllErrors().stream()
                // TODO : 显示校验失败的参数名
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return R.error(415, collect.toString());
    }
 
}