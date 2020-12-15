package com.yanyun.thread.base;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/13/18:07
 * @description
 */
public class ThreadGroupDemo {
    public static void main0(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("testThread当前线程组名字：" + Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字：" + Thread.currentThread().getName());
        });
        thread.start();
        System.out.println("执行main所在线程的线程组名字： " + Thread.currentThread().getThreadGroup().getName());
        System.out.println("执行main方法线程名字：" + Thread.currentThread().getName());
    }

    public static void main1(String[] args) {
        // 获取当前的线程组
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        // 复制一个线程组到一个线程数组（获取Thread信息）
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        System.out.println("执行main方法线程名字：" + threads.length);
    }

    public static void main(String[] args) {
        ThreadGroup threadGroup1 = new ThreadGroup("group1") {
            // 继承ThreadGroup并重新定义以下方法
            // 在线程成员抛出unchecked exception
            // 会执行此方法
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };

        // 这个线程是threadGroup1的一员
        Thread thread1 = new Thread(threadGroup1, new Runnable() {
            @Override
            public void run() {
                // 抛出unchecked异常
                throw new RuntimeException("测试异常");
            }
        });

        thread1.start();
    }
}
