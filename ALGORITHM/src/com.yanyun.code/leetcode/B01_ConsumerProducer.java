package com.yanyun.code.leetcode;

import lombok.SneakyThrows;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/09/04/11:14
 * @description 生产者消费者问题
 */
public class B01_ConsumerProducer {
    private volatile int count = 0;    // 产品数量
    private final static int MAX_SIZE = 4;  // 产品数量最大值
    final Lock lock = new ReentrantLock();
    final Condition full = lock.newCondition();
    final Condition empty = lock.newCondition();

    public static void main(String[] args) {
        B01_ConsumerProducer queue = new B01_ConsumerProducer();
        new Thread(queue.new Prodeucer()).start();
        new Thread(queue.new Prodeucer()).start();
        new Thread(queue.new Consumer()).start();
        new Thread(queue.new Consumer()).start();

    }

    class Prodeucer implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                lock.lock();
                try {
                    while (count == MAX_SIZE) { full.await(); }
                    count++;
                    System.out.println("我是生产者线程：" + Thread.currentThread().getName() + " 剩余产品数量：" + count);
                    full.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                lock.lock();
                try {
                    while (count == 0) { empty.await(); }
                    count--;
                    System.out.println("我是消费者线程：" + Thread.currentThread().getName() + " 剩余产品数量：" + count);
                    empty.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
