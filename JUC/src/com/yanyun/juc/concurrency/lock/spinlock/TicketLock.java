package com.yanyun.juc.concurrency.lock.spinlock;

import com.yanyun.juc.concurrency.lock.CustomThread;
import com.yanyun.juc.concurrency.lock.Operator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示排队自旋锁, 这种锁解决了公平性问题
 * <p>
 * Created by sunyiwei on 2016/12/6.
 */
public class TicketLock implements Operator {
    private final AtomicInteger serviceNum = new AtomicInteger();
    private final AtomicInteger currentNum = new AtomicInteger();
    private final ThreadLocal<Integer> ticketNum = new ThreadLocal<>();

    public static void main(String[] args) {
        TicketLock ticketLock = new TicketLock();

        final int COUNT = 200;
        for (int i = 0; i < COUNT; i++) {
            new CustomThread(ticketLock).start();
        }
    }

    public void lock() {
        //每个线程在进入这个之前,先拿到唯一的一个号
        ticketNum.set(currentNum.getAndIncrement());

        //服务号每次只会让拥有当前号码的线程进入
        while (ticketNum.get() != serviceNum.get()) {

        }
    }

    public void unlock() {
        //解锁的过程类似于叫号的过程
        serviceNum.getAndIncrement();
    }

}
