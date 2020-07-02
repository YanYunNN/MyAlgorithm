package com.yanyun.juc.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: YanYun
 * @Date: 2020/07/02/13:25
 * @Description: wait/notify 实现生产消费者模式
 */
public class WaitNotifyCPTest {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                synchronized (list) {
                    //判断list是否有数据，有数据就进入等待，等待消费
                    if (list.size() != 0) {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.add(UUID.randomUUID().toString());
                    list.notify();
               /*     list.add(UUID.randomUUID().toString());
                    list.add(UUID.randomUUID().toString());
                    list.notifyAll();*/
                    System.out.println(Thread.currentThread().getName() + list + "---" + System.currentTimeMillis() / 1000);
                }
            }
        }, "生产者线程A").start();

        new Thread(() -> {
            while (true) {
                synchronized (list) {
                    //判断list没有数据，就进入等待，等到有数据再通知消费
                    if (list.size() == 0) {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //有数据时
                    if (list.size() != 0) {
                        System.out.println(Thread.currentThread().getName() + list + "---" + System.currentTimeMillis() / 1000);
                    }
                    list.notify();
                    //读取完毕
                    list.clear();
                }
            }
        }, "消费者线程B").start();

        new Thread(() -> {
            while (true) {
                synchronized (list) {
                    //判断list没有数据，就进入等待，等到有数据再通知消费
                    if (list.size() == 0) {
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //有数据时
                    if (list.size() != 0) {
                        System.out.println(Thread.currentThread().getName() + list + "---" + System.currentTimeMillis() / 1000);
                    }
                    list.notify();
                    //读取完毕
                    list.clear();
                }
            }
        }, "消费者线程C").start();
    }
}
