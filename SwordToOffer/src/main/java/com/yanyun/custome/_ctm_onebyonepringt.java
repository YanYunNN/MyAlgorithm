package com.yanyun.custome;

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
public class _ctm_onebyonepringt {
    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static CountDownLatch count = new CountDownLatch(1);

    public static void main(String[] args) {
        String c = "ABCDEFGHI";
        char[] ca = c.toCharArray();
        String n = "123456789";
        char[] na = n.toCharArray();

        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                count.countDown();
                for (char zimu : ca) {
                    System.out.print(zimu);
                    c2.signal();
                    c1.await();
                }
                c1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                count.await();
                for (char num : na) {
                    System.out.print(num + "-");
                    c1.signal();
                    c2.await();
                }
                c2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }
}
