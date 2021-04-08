package com.yanyun.juc;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author xcai
 * @version 1.0
 * @date 2021/04/08/14:36
 * @description
 */
public class DeadLockTest {
    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (o1) {
                System.out.println("线程1锁o1");
                try {
                    Thread.sleep(1000);//让当前线程睡眠，保证让另一线程得到o2，防止这个线程启动一下连续获得o1和o2两个对象的锁。
                    synchronized (o2) {
                        System.out.println("线程1锁o2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (o2) {
                System.out.println("线程2锁o2");
                synchronized (o1) {
                    System.out.println("线程2锁o1");
                }
            }
        }).start();

    }
}
