package com.yanyun.sword;

public class _07_Fibonacci {
    /**
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * 0、1、1、2、3、5、8、13、21、34
     */

    //暴力法，递归（上->下）
    public int Fibonacci(int n) {
        if (n == 0 || n == 1) return n;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    //使用数组去除重复计算
    public int Fibonacci1(int n) {
        int[] ans = new int[40];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n];
    }

    //优化空间,DB算法（下->上）
    public int Fibonacci2(int n) {
        if (n == 0 || n == 1) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }


    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _07_Fibonacci clazz = new _07_Fibonacci();
        System.out.println(clazz.Fibonacci(4));
        System.out.println(clazz.Fibonacci1(4));
        System.out.println(clazz.Fibonacci2(4));
    }
}




