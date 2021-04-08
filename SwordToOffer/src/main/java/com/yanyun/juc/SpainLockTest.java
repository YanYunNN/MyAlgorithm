package com.yanyun.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author xcai
 * @version 1.0
 * @date 2021/04/08/15:11
 * @description
 */
public class SpainLockTest {
    /**
     * CAS手写自旋锁
     */
    static class MySpainLock {
        AtomicReference<Thread> atomicReference = new AtomicReference<>();
        //可重入
        private int lockCount = 0;

        public void lock() {
            while (!atomicReference.compareAndSet(null, Thread.currentThread())) {
            }
        }

        public void unlock() {
            atomicReference.compareAndSet(Thread.currentThread(), null);
        }


        //不可重入
        public void reLock() {
            // 获取内存值，若已取到锁（初始值为null，当内存值也为null说明取到锁了），则计数器累加、退出方法
            if (Thread.currentThread() == atomicReference.get()) {
                lockCount++;
                return;
            }
            while (!atomicReference.compareAndSet(null, Thread.currentThread())) {
            }
        }

        public void reUnlock() {
            if (Thread.currentThread() == atomicReference.get()) {
                if (lockCount != 0) {
                    lockCount--;
                } else {
                    atomicReference.compareAndSet(Thread.currentThread(), null);
                }
            }

        }

        public static void main(String[] args) {
            MySpainLock lock = new MySpainLock();
            new Thread(() -> {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " lock");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " unlock");
            }).start();

            new Thread(() -> {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " lock");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " unlock");
            }).start();

            // 第一次获取锁
            lock.lock();
            System.out.println("我来了.");
            // 第二次获取锁
            lock.lock();
            System.out.println("我又来了.");
            lock.unlock();
            lock.unlock();
        }
    }
}
