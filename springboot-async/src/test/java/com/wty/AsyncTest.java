package com.wty;

import com.wty.service.AsyncService;
import com.wty.service.CompletableFutureService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步服务功能测试
 *
 * @author wty
 * @date 2020/5/4 17:14
 */
@Slf4j
@SpringBootTest(classes = {AsyncApplication.class})
public class AsyncTest {

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private CompletableFutureService completableFutureService;

    @Test
    public void contextLoad() {
    }

    @Test
    public void testAsyncProcess() throws InterruptedException {
        asyncService.asyncProcess();
        log.info("coming in testAsyncProcess...");
    }

    @Test
    public void testAsyncProcessHasReturn() throws Exception {
        long start = System.currentTimeMillis();
        Future<Integer> result = asyncService.asyncProcessHasReturn();
        log.info("get async task value: {}",
                result.get());
        log.info("time elapse for async task: {}ms",
                System.currentTimeMillis() - start);
    }

    @Test
    public void callAsyncService() throws InterruptedException, ExecutionException {
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
        System.out.println("ok" + System.currentTimeMillis());
    }
    @Test
    public void callCompile() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        log.info("方法执行开始：{}", start);
        completableFutureService.supplyAsync();
        long syncTime = System.currentTimeMillis();
        log.info("异步方法用时：{}", syncTime - start);
    }
}
