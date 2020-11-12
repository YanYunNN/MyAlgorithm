package com.yanyun.juc.concurrency;

/**
 * 测试java中的wait/notify机制
 * <p>
 * 1. wait/notify/notifyAll方法必须在持有该对象锁的线程中调用, 否则会抛出IllegalMonitorStateException
 * <p>
 * 2. 调用了wait之后, 线程释放对象锁
 * <p>
 * Created by sunyiwei on 2017/4/27.
 */
public class NotifyWaitTester {
    public static void main(String[] args) {
        Object obj = new Object();

        new Thread(() -> {
            synchronized (obj) {
                try {
                    obj.wait();

                    System.out.println("after wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (obj) {
                obj.notifyAll();

                System.out.println("after notify all");
            }
        }).start();

        while (true) {

        }
    }
}
