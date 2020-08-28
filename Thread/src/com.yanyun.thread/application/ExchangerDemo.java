package com.yanyun.thread.application;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/28/10:41
 * @description
 */
public class ExchangerDemo {

    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        synchronized (exchanger) {
            new Thread(() -> {
                try {
                    System.out.println("这是线程A，得到了另一个线程的数据："/* + exchanger.exchange("这是来自线程A的数据")*/);
                    System.out.println("这是线程A，得到了另一个线程的数据2：" + exchanger.exchange("这是来自线程A的数据"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println("这个时候线程A是阻塞的，在等待线程B的数据");
        Thread.sleep(1000);

        new Thread(() -> {
            try {
                System.out.println("这是线程B，得到了另一个线程的数据：" + exchanger.exchange("这是来自线程B的数据"));
                System.out.println("这是线程B，得到了另一个线程的数据2：" + exchanger.exchange("这是来自线程B的数据", 5, TimeUnit.SECONDS));
            } catch (InterruptedException | TimeoutException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
