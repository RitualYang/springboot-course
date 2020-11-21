package com.wty.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/**
 * @author wty
 * @date 2020/8/25 12:17
 */
@Slf4j
@Service
public class CompletableFutureService {

    @Autowired
    private Executor asyncExecutor;

    public void supplyAsync() throws ExecutionException, InterruptedException {
        /*异步执行*/
        CompletableFuture<Integer> infoFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("异步方法调用结束时间：{}", System.currentTimeMillis());
            return 1001;
        }, asyncExecutor);
        /*需等待infoFuture方法执行完毕才能执行*/
        CompletableFuture<Void> voidCompletableFuture = infoFuture.thenAcceptAsync((res) -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("获取infoFuture的参数为：{},调用时间：{}", res, System.currentTimeMillis());
        }, asyncExecutor);
        /*需等待infoFuture方法执行完毕才能执行*/
        CompletableFuture<Void> voidCompletableFutureAdd = infoFuture.thenAcceptAsync((res) -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("获取infoFuture的参数并加数为：{},调用时间：{}", res + 100, System.currentTimeMillis());
        }, asyncExecutor);
        // 需要等待异步方法全部执行完毕,需打开以下注释
//        CompletableFuture.allOf(infoFuture,voidCompletableFuture,voidCompletableFutureAdd).get();
    }
}
