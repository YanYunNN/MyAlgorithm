package com.yanyun.thread.base;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/20/19:18
 * @description
 */
public class ObjectLock {

    private static final Object lock = new Object();

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread A " + i);
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread B " + i);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //同一时间只有一个线程持有一个锁，那么线程B就会等线程A执行完成后释放lock，线程B才能获得锁lock。
        new Thread(new ThreadA()).start();
        //使用sleep方法睡眠了10毫秒，是为了防止线程B先得到锁。
        // 因为如果同时start，线程A和线程B都是出于就绪状态，操作系统可能会先让B运行。这样就会先输出B的内容，然后B执行完成之后自动释放锁，线程A再执行。
        Thread.sleep(0);
        new Thread(new ThreadB()).start();
    }
}
