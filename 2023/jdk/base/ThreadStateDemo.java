package com.yanyun.thread.base;

import org.junit.Test;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/20/17:04
 * @description
 */
public class ThreadStateDemo {
    @Test
    public void blockedTest() throws InterruptedException {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
        System.out.println("----------------------------------------");

        a.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
        System.out.println("----------------------------------------");

        Thread.sleep(1000L); // 需要注意这里main线程休眠了1000毫秒，而testMethod()里休眠了2000毫秒
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
        System.out.println("----------------------------------------");

        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？


    }

    @Test
    public void blockedTest1() throws InterruptedException {
        Thread a = new Thread(() -> testMethod(), "a");
        Thread b = new Thread(() -> testMethod(), "b");
        a.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出 TERMINATED
        a.join();
        System.out.println(a.getName() + ":" + a.getState()); // 输出 TERMINATED
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出 TERMINATED
        System.out.println(b.getName() + ":" + b.getState());
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
