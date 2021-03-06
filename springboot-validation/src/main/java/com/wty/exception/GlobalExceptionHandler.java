package com.wty.exception;

import com.wty.model.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 参数校验拦截
 *
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
        log.info("参数校验失败,异常:BindException");
        List<String> collect = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return R.error(415, collect.toString());
    }

    /**
     * 方法参数校验异常(配合@requestBody使用时,会抛出此异常)
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R methodArgumentNotValidException(MethodArgumentNotValidException e){
        log.info("参数校验失败,异常:MethodArgumentNotValidException");
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return R.error(415,message);
    }

    /**
     * 方法校验异常拦截,list类型拦截
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public R constraintViolationException(ConstraintViolationException e) {
        log.info("参数校验失败");
        //TODO: 美化消息
        return R.error(415, e.getMessage());
    }

}