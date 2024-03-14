package com.yanyun.sword.juc.Thread;

/**
 * @Auther: YanYun
 * @Date: 2020/07/02/13:25
 * @Description:
 */
public class WaitNotifyTest {
    static Object object = new Object();

    public static void main(String[] args) {
        long time = System.currentTimeMillis() / 1000;
        new Thread(() -> {
            synchronized (object) {
                System.out.println("开始线程A---" + System.currentTimeMillis() / 1000);
                try {
                    object.wait();
                    System.out.println("线程A重新获得锁---" + System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("结束线程A---" + System.currentTimeMillis() / 1000);
            }
        }, "线程A").start();

        new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                System.out.println("开始线程B---" + System.currentTimeMillis() / 1000);
                object.notify();
                System.out.println("线程B通知完线程A---" + System.currentTimeMillis() / 1000);
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("结束线程B---" + System.currentTimeMillis() / 1000);
            }
        }, "线程B").start();
    }
}
