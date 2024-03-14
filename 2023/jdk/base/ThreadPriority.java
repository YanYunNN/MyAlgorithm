package com.yanyun.thread.base;

import java.util.stream.IntStream;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/20/14:11
 * @description
 */
public class ThreadPriority {
    public static void main0(String[] args) {
        Thread a = new Thread();
        System.out.println("默认优先级" + a.getPriority());
        Thread b = new Thread();
        b.setPriority(10);
        System.out.println("自定义优先级" + b.getPriority());
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(String.format("当前执行的线程是：%s，优先级：%d",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority()));
        }
    }

    public static void main1(String[] args) {
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });
    }

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("t1");
        threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup, "thread");
        thread.setPriority(1);
        System.out.println("我是线程组的优先级" + threadGroup.getMaxPriority());
        System.out.println("我是线程的优先级" + thread.getPriority());
    }
}
