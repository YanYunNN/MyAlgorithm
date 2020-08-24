package com.yanyun.thread.base;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/12/20:22
 * @description
 */
public class ThreadDemo {
    public static class MyThread1 extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread1");
        }
    }

    public static class MyThread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread2");
        }
    }

    public static void main0(String[] args) {
        /**
         * Thread
         */
        Thread myThread = new MyThread1();
        System.out.println("MyThread1");
        myThread.start();
//        myThread.start();
        /**
         * Runnable
         */
        new Thread(new MyThread2()).start();
        new Thread(() -> System.out.println("java 8 匿名内部类")).start();
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        /**
         * Thread
         */
        Thread myThread = new MyThread1();
        System.out.println("MyThread1");
        System.out.println(myThread.getState());
        myThread.start();
        System.out.println(myThread.getState());
        myThread.start();
    }
}
