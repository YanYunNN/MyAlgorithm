package com.yanyun.thread.thoery;

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
}