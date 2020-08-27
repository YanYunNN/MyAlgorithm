package com.yanyun.thread.practice.easy;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/26/19:43
 * @description
 */
public class BlockQueueDemo {

    private static final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
//        System.out.println(queue.add(1));
        System.out.println(queue.offer(1));
        try {
            System.out.println(queue.element());
            System.out.println(queue.poll());
            System.out.println(queue.peek());
            System.out.println(queue.offer(2, 2000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
