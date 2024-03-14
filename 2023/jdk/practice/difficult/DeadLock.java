package com.yanyun.thread.practice.difficult;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/26/10:38
 * @description
 */
public class DeadLock {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        a.next = b;
        b.next = a;
        new Thread(a, "aThread").start();
        new Thread(b, "bThread").start();
    }
}

class A extends T implements Runnable {
    T next;

    @Override
    public synchronized void invoke() {
        System.out.println("当前线程：" + Thread.currentThread().getName()
                + " | 进入了" + this.getClass().getSimpleName() + " 获取到资源 | 准备调用："
                + next.getClass().getSimpleName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        next.invoke();
    }

    @Override
    public void run() {
        invoke();
    }
}

class B extends T implements Runnable {
    T next;

    @Override
    public synchronized void invoke() {
        System.out.println("当前线程：" + Thread.currentThread().getName()
                + " | 进入了" + this.getClass().getSimpleName() + " 获取到资源 | 准备调用："
                + next.getClass().getSimpleName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        next.invoke();
    }

    @Override
    public void run() {
        invoke();
    }
}

class T {
    public synchronized void invoke() {
    }
}