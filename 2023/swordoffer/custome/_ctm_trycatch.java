package com.yanyun.custome;

import java.util.concurrent.Executors;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/17/19:36
 * @description [算法]
 */
public class _ctm_trycatch {

    public static void main(String[] args) {
        System.out.println(A());
//        Executors.newFixedThreadPool();
//        Executors.newScheduledThreadPool();
//        Executors.newCachedThreadPool();
//        Executors.newScheduledThreadPool();

    }

    static int A() {
        int i;
        try {
            i = 1;
            i = i / 0;
            System.exit(0);
        } catch (Exception e) {
            return i = 2;
        } finally {
            i = 3;
            return i;
        }
    }
}
