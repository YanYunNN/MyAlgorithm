package com.yanyun.juc.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试可重入锁是否为自旋锁
 * <p>
 * 验证结果为: 不是
 * <p>
 * Created by sunyiwei on 2016/12/6.
 */
public class ReentranLockTester {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        final int COUNT = 10;
        for (int i = 0; i < COUNT; i++) {
            Thread t1 = new CustomThread(reentrantLock);
            t1.start();
        }
    }

    private static class CustomThread extends Thread {
        private final Lock lock;

        public CustomThread(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                System.out.println(Thread.currentThread());
                lock.unlock();
            }
        }
    }
}

