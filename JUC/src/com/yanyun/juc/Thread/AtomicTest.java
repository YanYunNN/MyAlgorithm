package com.yanyun.juc.Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 异步
 */
public class AtomicTest {

    private final AtomicInteger inc = new AtomicInteger();

    public void increase() {
        inc.getAndIncrement();
    }

    public static void main(String[] args) {
        final AtomicTest volatileTest = new AtomicTest();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    volatileTest.increase();
                }
            });
            thread.start();
        }
        System.out.println(Thread.activeCount());
        //保证前面线程全部执行完
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + ":" + volatileTest.inc);
    }
}