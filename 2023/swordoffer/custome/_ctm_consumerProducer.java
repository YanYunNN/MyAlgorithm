package com.yanyun.custome;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xcai
 * @version 1.0
 * @date 2021/03/19/20:52
 * @description
 */
public class _ctm_consumerProducer {
    private static Object[] tab;
    private int takeIndex;
    private int putIndex;
    private static int size;
    private static Lock lock = new ReentrantLock();
    private static Condition notFull;
    private static Condition notEmpty;

    public _ctm_consumerProducer(int tabCount) {
        if (tabCount < 0) {
            new NullPointerException();
        }
        tab = new Object[tabCount];
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    public boolean offer(Object obj) {
        lock.lock();
        try {
            if (obj == null) throw new NullPointerException();
            while (tab.length == size) {
                System.out.println("队列满！");
                notFull.await();
            }
            tab[putIndex++] = obj;
            size++;
            //重置
            if (putIndex == tab.length) putIndex = 0;
            notEmpty.signal();
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
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
            Object obj = tab[takeIndex++];
            //重置
            if (takeIndex == tab.length) takeIndex = 0;
            size--;
            notFull.signal();
            return obj;
        } catch (InterruptedException e) {
            e.printStackTrace();
            notFull.signal();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        _ctm_consumerProducer queue = new _ctm_consumerProducer(5);

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.offer(i);
                System.out.println("生产者1生产了：" + i + "队列size：" + size);
            }
        }, "producer1").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.offer(i);
                System.out.println("生产者2生产了：" + i + "队列size：" + size);
            }
        }, "producer2").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Object poll = queue.poll();
                System.out.println("消费者1消费了：" + poll + "队列size：" + size);
            }
        }, "consumer1").start();

       /* new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Object poll = queue.poll();
                System.out.println("消费者2消费了：" + poll + "队列size：" + size);
            }
        }, "consumer2").start();*/
    }
}
