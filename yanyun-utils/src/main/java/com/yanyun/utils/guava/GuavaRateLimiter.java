package com.yanyun.utils.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/15/19:54
 * @description
 */
public class GuavaRateLimiter {

    public static ConcurrentHashMap<String, RateLimiter> resourceRateLimiter = new ConcurrentHashMap<>();

    //初始化限流工具RateLimiter
    static {
        createResourceRateLimiter("order", 10);
    }

    public static void createResourceRateLimiter(String resource, double qps) {
        if (resourceRateLimiter.contains(resource)) {
            resourceRateLimiter.get(resource).setRate(qps);
        } else {
            //创建限流工具，每秒发出50个令牌指令
            RateLimiter rateLimiter = RateLimiter.create(qps);
            resourceRateLimiter.putIfAbsent(resource, rateLimiter);

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                //如果获得令牌指令，则执行业务逻辑
                //设置等待超时时间的方式获取令牌，如果超timeout为0，则代表非阻塞，获取不到立即返回
                if (resourceRateLimiter.get("order").tryAcquire(10, TimeUnit.MICROSECONDS)) {
                    System.out.println("执行业务逻辑");
                } else {
                    System.out.println("限流");
                }
            }).start();
        }

    }
}
