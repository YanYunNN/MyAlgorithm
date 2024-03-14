package com.yanyun.sword.juc.Thread;

/**
 * 异步
 */
public class VolatileTest {

    private volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileTest volatileTest = new VolatileTest();
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
            //使当前线程从执行状态（运行状态）变为可执行态（就绪状态）。
            //当前线程到了就绪状态，那么接下来哪个线程会从就绪状态变成执行状态呢？可能是当前线程，也可能是其他线程，看系统的分配了。
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + ":" + volatileTest.inc);
    }
}