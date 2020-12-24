package com.yanyun.sword.juc.Async;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
public class TaskExecutorConfiguration implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setKeepAliveSeconds(1000);// 空闲时间
        taskExecutor.setCorePoolSize(5);// 线程池大小
        taskExecutor.setMaxPoolSize(10);// 线程池最大线程数
        taskExecutor.setQueueCapacity(25);// 最大等待任务数
        taskExecutor.initialize();
        return taskExecutor;
    }

    public static void main(String[] args) {
        //使用自定义线程池异步
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //使用默认线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //异步任务提交
        executorService.submit(() -> {
            try {
                System.out.println("异步消息");
            } catch (Exception e) {
                throw new RuntimeException("异步发送消息出错!");
            }
        });
    }
}
