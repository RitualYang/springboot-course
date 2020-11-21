package com.wty.controller;

import com.wty.service.AsyncService;
import com.wty.service.CompletableFutureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author wty
 * @date 2020/8/25 10:31
 */
@Slf4j
@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private CompletableFutureService completableFutureService;

    @GetMapping("/call")
    private String callAsyncService() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        log.info("方法执行开始：{}", start);
        asyncService.syncProcess();
        long syncTime = System.currentTimeMillis();
        log.info("同步方法用时：{}", syncTime - start);
        asyncService.asyncProcess();
        long asyncTime = System.currentTimeMillis();
        log.info("异步方法用时：{}", asyncTime - syncTime);
        log.info("方法执行完成：{}!", asyncTime);
        Future<Integer> integerFuture = asyncService.asyncProcessHasReturn();
        long asyncReturnTime = System.currentTimeMillis();
        log.info("异步方法获取参数：{},用时：{}", integerFuture.get(), asyncReturnTime - asyncTime);
        return "ok" + System.currentTimeMillis();
    }

    @GetMapping("/callCompile")
    public String callCompile() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        log.info("方法执行开始：{}", start);
        completableFutureService.supplyAsync();
        long syncTime = System.currentTimeMillis();
        log.info("异步方法用时：{}", syncTime - start);
        return "ok";
    }
}
