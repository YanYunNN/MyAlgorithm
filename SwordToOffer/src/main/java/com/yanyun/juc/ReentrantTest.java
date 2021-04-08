package com.yanyun.juc;

/**
 * @author xcai
 * @version 1.0
 * @date 2021/04/08/14:36
 * @description
 */
public class ReentrantTest {
    /**
     * 可重入锁
     */
    public static class MyLock {
        private boolean isLock;
        private Thread lockOwner;
        private int lockCount;

        public synchronized void lock() throws InterruptedException {
            while (isLock && Thread.currentThread() != lockOwner) {
                wait();
            }
            isLock = true;
            lockOwner = Thread.currentThread();
            lockCount++;
        }

        public synchronized void unlock() {
            while (isLock && Thread.currentThread() == lockOwner) {
                lockCount--;
                if (lockCount == 0) {
                    isLock = false;
                    notify();
                }
            }
        }


        public static void main(String[] args) throws InterruptedException {
            MyLock lock = new MyLock();
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ",A");
            //重入
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + ",b");
            } finally {
                lock.unlock();
            }
            System.out.println("可以重入原锁！");
            lock.unlock();
        }
    }

    /**
     * 不可重入锁
     */
    public static class MyUnEntrantLock {
        private boolean isLock;
        private int lockCount;

        public synchronized void lock() throws InterruptedException {
            while (isLock) {
                wait();
            }
            isLock = true;
        }

        public synchronized void unlock() {
            while (isLock) {
                isLock = false;
                notify();
            }
        }


        public static void main(String[] args) throws InterruptedException {
            MyUnEntrantLock lock = new MyUnEntrantLock();
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ",A");
            //重入
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + ",b");
            } finally {
                lock.unlock();
            }
            System.out.println("可以重入原锁！");
            lock.unlock();
        }
    }
}
