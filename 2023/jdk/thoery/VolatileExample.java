package com.yanyun.thread.thoery;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/08/12/20:22
 * @description
 */
public class VolatileExample {
    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1; // step 1
        flag = true; // step 2
    }

    public void reader() {
        if (flag) { // step 3
            System.out.println(a); // step 4
        }
        synchronized (new Object()) {

        }
    }

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();
        AtomicReference<Object> atomicReference = new AtomicReference<>();
    }
}