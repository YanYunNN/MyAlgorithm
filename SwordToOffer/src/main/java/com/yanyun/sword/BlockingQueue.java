package com.yanyun.sword;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/16/18:59
 * @description 手写阻塞队列
 */
public class BlockingQueue {
    //队列容器
    private Object[] tab;
    //出队下标
    private int takeIndex;
    //入队下标
    private int putIndex;
    //元素数量
    private int size;
    private ReentrantLock lock = new ReentrantLock();

    private Condition notEmpty;
    private Condition notFull;

    public BlockingQueue(int tabCount) {
        if (tabCount < 0) {
            new NullPointerException();
        }

        tab = new Object[tabCount];
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        lock.lock();
        try {
            while (size == tab.length) {
                System.out.println("队列满！");
                //阻塞
                notFull.await();
            }
            tab[putIndex] = obj;
            //游标
            if (++putIndex == tab.length) {
                putIndex = 0;
            }
            size++;
            notEmpty.signal();
            return true;
        } catch (Exception e) {
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
        return false;
    }

    public Object poll() {
        lock.lock();
        try {
            while (size == 0) {
                System.out.println("队列空！");
                notEmpty.await();
            }
            Object obj = tab[takeIndex];
            if (++takeIndex == tab.length) {
                takeIndex = 0;
            }
            size--;
            notFull.signal();
            return obj;
        } catch (Exception e) {
            notFull.signal();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue(5);
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingQueue.offer(i);
                System.out.println("生产者生产了：" + i);
            }
        }, "producer").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Object poll = blockingQueue.poll();
                System.out.println("消费者消费了：" + poll);
            }
        }, "consumer").start();

    }
}
