package com.yanyun.thread.base;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/13/18:07
 * @description
 */
public class ThreadGroupDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("testThread当前线程组名字：" + Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字：" + Thread.currentThread().getName());
        });
        thread.start();
        System.out.println("执行main所在线程的线程组名字： " + Thread.currentThread().getThreadGroup().getName());
        System.out.println("执行main方法线程名字：" + Thread.currentThread().getName());
    }
}
