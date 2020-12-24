package com.yanyun.sword.juc.Thread;

/**
 * 异步
 */
public class SynchronizedTest {

    private int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final SynchronizedTest volatileTest = new SynchronizedTest();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    volatileTest.increase();
                }
            });
            thread.start();
        }
        System.out.println(Thread.activeCount());
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + ":" + volatileTest.inc);
    }
}