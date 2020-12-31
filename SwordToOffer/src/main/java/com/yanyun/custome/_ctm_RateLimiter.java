package com.yanyun.custome;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/17/19:36
 * @description [算法]
 */
public class _ctm_RateLimiter {


    public static void main(String[] args) {

    }

    /**
     * ---------------------------------------------------计数器限流-----------------------------------------------------
     */
    public static AtomicInteger counter = new AtomicInteger(0);
    public static AtomicInteger threshold = new AtomicInteger(100);

    public static boolean tryAcquire0() {
        if (counter.get() < threshold.get()) {
            counter.incrementAndGet();
            return true;
        }
        return false;
    }

    /**
     * ---------------------------------------------------固定窗口限流---------------------------------------------------
     */
    public static long timeWindow = 30 * 1000;
    public static long lastAcquireTimeMills = System.currentTimeMillis();

    public static boolean tryAcquire1() {
        long now = System.currentTimeMillis();
        if (now - lastAcquireTimeMills > timeWindow) {
            counter.set(0);
            lastAcquireTimeMills = now;
        }
        if (counter.get() < threshold.get()) {
            counter.incrementAndGet();
            return true;
        }
        return false;
    }

    /**
     * ---------------------------------------------------滑动窗口限流---------------------------------------------------
     */
    public static boolean tryAcquire2() {
        long now = System.currentTimeMillis();
        return true;
    }
    /**
     * ---------------------------------------------------漏桶限流---------------------------------------------------
     */
    public static boolean tryAcquire3() {
        long now = System.currentTimeMillis();
        return true;
    }
    /**
     * ---------------------------------------------------令牌桶限流---------------------------------------------------
     */
    public static boolean tryAcquire4() {
        long now = System.currentTimeMillis();
        return true;
    }
}
