package com.yanyun.thread.base;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/20/19:50
 * @description
 */
public class Join {
    static class ThreadA implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("我是子线程，我先睡一秒");
                Thread.sleep(1000);
                System.out.println("我是子线程，我睡完了一秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadA());
        thread.start();

        //加了wait，非法状态异常
        System.out.println(thread.getState());
        thread.wait();
        System.out.println(thread.getState());

        thread.join();
        System.out.println("如果不加join方法，我会先被打出来，加了就不一样了");
    }
}
