package com.yanyun.juc;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author xcai
 * @version 1.0
 * @date 2021/04/08/14:36
 * @description
 */
public class NoFairAQSTest implements Lock {
    AtomicInteger status = new AtomicInteger();
    LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();
    Thread owner = null;

    @Override
    public void lock() {
        if (!tryLock()) {
            waiters.add(Thread.currentThread());
            for (; ; ) {
                if (tryLock()) {
                    waiters.poll();
                    return;
                } else {
                    LockSupport.park();
                }
            }
        }
    }

    @Override
    public boolean tryLock() {
        if (status.get() == 0) {
            //判断当前拥有锁的线程的状态是否为0，为0，执行状态值+1，并将当前线程设置为锁拥有者。
            if (status.compareAndSet(0, 1)) {
                owner = Thread.currentThread();
                return true;
            }
            // 实现锁可重入
            else if (owner == Thread.currentThread()) {
                status.set(status.get() + 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public void unlock() {
        if (owner != Thread.currentThread()) {
            throw new RuntimeException("非法操作");
        }
        //尝试解锁成功
        if (status.decrementAndGet() == 0) {
            owner = null;
            // 从等待队列中获取前置线程并唤醒
            Thread peek = waiters.peek();
            if (peek != null) {
                LockSupport.unpark(peek);
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
