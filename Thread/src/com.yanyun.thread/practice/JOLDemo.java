package com.yanyun.thread.practice;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/19/14:31
 * @description 打印一个对象
 */
public class JOLDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 等待初始化的重量锁加载，为了展示偏向锁
         */
        Thread.sleep(5000);

        Object o = new Object();
        String printable = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(printable);

        /**
         * 轻量级锁
         */
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        /**
         * 锁竞争，重量级锁
         */
        new Thread(() -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getThreadGroup().getName());
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }, "Thread-1").start();
        new Thread(() -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getThreadGroup().getName());
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        }, "Thread-2").start();


        /**
         * 无锁
         */
        Thread.sleep(3000);
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
