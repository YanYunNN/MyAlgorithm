package com.yanyun;

public class _09_JumpFloorII {
    /**
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级，n级，求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
     * <p>
     * 贪心算法
     * 0-1; 1-1 ;3-4
     * 递推公式
     * <p>
     * ************| 1       ,(n=0 )
     * <p>
     * f(n) =      | 1       ,(n=1 )
     * <p>
     * ************| 2*f(n-1),(n>=2)
     */

    //递推法
    //f(n) =2f(n-1)
    public int JumpFloorII(int n) {
        if (n <= 1) return n;
        return 2 * JumpFloorII(n - 1);
    }

    //演算法1
    //每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用2^(n-1)中情况
    public int JumpFloorII1(int n) {
        if (n <= 1) return n;
//        return (int) Math.pow(2, n - 1);
        return 1 << n - 1;
    }

    //演算法2
    //每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用2^(n-1)中情况
    public int JumpFloorII1_1(int n) {
        return 1 << n - 1;
    }

    //动态规划，递归减少计算1
    public int JumpFloorII2(int n) {
        int[] f = new int[n + 1];
        f[0] = f[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                f[i] += f[j];
            }
        }
        return f[n];
    }

    //动态规划，递归减少计算2
    public int JumpFloorII3(int n) {
        if (n <= 1) return n;
        int a = 1, b = 0;
        for (int i = 2; i <= n; ++i) {
            b = a << 1;
            a = b;
        }
        return b;
    }


    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _09_JumpFloorII clazz = new _09_JumpFloorII();
        System.out.println(clazz.JumpFloorII(3));
        System.out.println(clazz.JumpFloorII1(3));
        System.out.println(clazz.JumpFloorII1_1(3));
        System.out.println(clazz.JumpFloorII2(3));
        System.out.println(clazz.JumpFloorII3(3));
    }
}




