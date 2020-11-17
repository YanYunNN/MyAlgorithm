package com.yanyun;

public class _08_JumpFloor {
    /**
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
     * <p>
     * 逆向倒退，n级，往下跳，有n-1，n-2俩种可能，依次递归
     * 1-1;4-5
     */

    //暴力法，递归（上->下）
    public int JumpFloor(int n) {
        if (n == 0 || n == 1 || n == 2) return n;
        return JumpFloor(n - 1) + JumpFloor(n - 2);
    }

    //使用数组去除重复计算
    public int JumpFloor1(int n) {
        int[] array = new int[40];
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    //优化空间,DB算法（下->上）
    public int JumpFloor2(int n) {
        if (n == 0 || n == 1 || n == 2) return n;
        int a = 1, b = 2, c = 0;
        for (int i = 3; i < n + 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    //优化空间,DB算法（下->上）
    public int JumpFloor3(int n) {
        if (n == 0 || n == 1 || n == 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i < n + 1; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _08_JumpFloor clazz = new _08_JumpFloor();
        System.out.println(clazz.JumpFloor(4));
        System.out.println(clazz.JumpFloor1(4));
        System.out.println(clazz.JumpFloor2(4));
        System.out.println(clazz.JumpFloor3(4));
        System.out.println(clazz.JumpFloor(1));
        System.out.println(clazz.JumpFloor(1));
        System.out.println(clazz.JumpFloor1(1));
        System.out.println(clazz.JumpFloor1(2));
        System.out.println(clazz.JumpFloor2(2));
        System.out.println(clazz.JumpFloor2(2));
    }
}




