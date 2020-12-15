package com.yanyun.distribute;

import org.springframework.scheduling.annotation.Async;

import java.util.Scanner;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/15/18:49
 * @description 限流桶算法
 * 在SpringCloud分布式下实现限流，需要把令牌桶的维护放到一个公共的地方，比如Zuul路由，另外，guava里有现成的基于令牌桶的限流实现。
 */
public class RateLimiter {
    /**
     * 桶的大小
     */
    private Integer limit;

    /**
     * 桶当前的token
     */
    private static Integer tokens = 0;

    /**
     * 构造参数
     */
    public RateLimiter(Integer limit, Integer speed) {
        //初始化桶的大小，且桶一开始是满的
        this.limit = limit;
        RateLimiter.tokens = this.limit;

        //任务线程：每秒新增speed个令牌
        asyncTask(speed);
    }

    /**
     * 优雅异步任务
     */
    @Async("asyncTaskExecutor")
    public void asyncTask(Integer speed) {
        while (true) {
            try {
                Thread.sleep(1000L);
                int newTokens = tokens + speed;
                if (newTokens > limit) {
                    tokens = limit;
                    System.out.println("满了！");
                } else {
                    tokens = newTokens;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("满了！");
            }
        }
    }

    /**
     * 根据令牌数判断是否允许执行，需要加锁
     */
    public synchronized boolean execute() {
        if (tokens > 0) {
            tokens -= 1;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //令牌桶限流：峰值每秒可以处理10个请求，正常每秒可以处理3个请求
        RateLimiter rateLimiter = new RateLimiter(10, 3);

        //模拟请求
        while (true) {
            //在控制台输入一个值按回车，相对于发起一次请求
            Scanner scanner = new Scanner(System.in);
            scanner.next();

            //令牌桶返回true或者false
            if (rateLimiter.execute()) {
                System.out.println("允许访问");
            } else {
                System.err.println("禁止访问");
            }
        }
    }
}
