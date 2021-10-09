package com.wty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wty
 * @date 2021/10/9 15:39
 * 描述: 线程池状态
 */
@RestController
@RequestMapping("/pool")
public class PoolController {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 获取全部的线程池状态
     *
     * @return
     */
    @GetMapping("getAllPoolStatus")
    public List<String> getAllPoolStatus() {
        List<String> list = new ArrayList();
        Map<String, Executor> executorMap = applicationContext.getBeansOfType(Executor.class);
        executorMap.forEach((name, executor) -> {
            if (executor instanceof ThreadPoolExecutor) {
                ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) executor;
                BlockingQueue<Runnable> queue = poolExecutor.getQueue();
                list.add(String.format("线程名:%s, 核心线程数:%s, 活动线程数:%s, 最大线程数:%s, 任务完成数:%s, 队列大小:%s, 当前排队线程数:%s, 队列剩余大小:%s",
                        name, poolExecutor.getCorePoolSize(),
                        poolExecutor.getActiveCount(), poolExecutor.getMaximumPoolSize(),
                        poolExecutor.getCompletedTaskCount(), (queue.size() + queue.remainingCapacity()),
                        queue.size(), queue.remainingCapacity()));
            }
            if (executor instanceof ThreadPoolTaskExecutor) {
                ThreadPoolTaskExecutor poolExecutor = (ThreadPoolTaskExecutor) executor;
                BlockingQueue<Runnable> queue = poolExecutor.getThreadPoolExecutor().getQueue();
                list.add(String.format("线程名:%s, 核心线程数:%s, 活动线程数:%s, 最大线程数:%s, 队列大小:%s, 当前排队线程数:%s, 队列剩余大小:%s",
                        name, poolExecutor.getCorePoolSize(),
                        poolExecutor.getActiveCount(), poolExecutor.getMaxPoolSize(), (queue.size() + queue.remainingCapacity()),
                        queue.size(), queue.remainingCapacity()));
            }
        });
        return list;
    }
}
