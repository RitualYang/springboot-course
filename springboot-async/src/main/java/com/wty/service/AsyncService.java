package com.wty.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步处理服务
 *
 * @author wty
 * @date 2020/5/4 16:48
 */
@Slf4j
@Service
public class AsyncService {

    /**
     * 异步调用方法
     *
     * @throws InterruptedException
     */
    @Async("asyncExecutor")
    public void asyncProcess() throws InterruptedException {
        log.info("async process task, current thread name -> {}",
                Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
    }

    /**
     * 同步调用方法
     *
     * @throws InterruptedException
     */
    public void syncProcess() throws InterruptedException {
        log.info("async process task, current thread name -> {}",
                Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
    }

    /**
     * 带有返回值的异步方法(适合在存在多个方法调用时间过长时使用)
     *
     * @return
     * @throws InterruptedException
     */
    @Async("asyncExecutor")
    public Future<Integer> asyncProcessHasReturn() throws InterruptedException {
        log.info("async process task (has return), current thread name -> {}",
                Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
        return new AsyncResult<>(1000);
    }

}
