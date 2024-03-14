package com.yanyun.sword;

public class _012_Power {
    /**
     * 奇数：if ((n & 1) == 1)
     * 余数：i %（2^n） = i & (n-1)
     */
    /**
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0
     * 2-3
     */
    public double Power(double base, int exponent) {
        if (base == 0 && exponent <= 0) throw new RuntimeException();
        if (base == 0 && exponent > 0) return 0;
        if (base != 0 && exponent == 0) return 1;
        double res = 1;
        int abs = Math.abs(exponent);
        while (abs != 0) {
            res *= base;
            abs--;
        }
        return exponent < 0 ? 1 / res : res;
    }

    /**
     * 位运算
     * 3的5次方=3的（5=101=2^2+2^0）= 3的4次方 * 3的一次方
     */
    public double Power1(double base, int exponent) {
        if (base == 0 && exponent <= 0) throw new RuntimeException();
        if (base == 0 && exponent > 0) return 0;
        if (base != 0 && exponent == 0) return 1;
        //略
        return 1;
    }


    /**
     * 递归
     * 3的5次方=3四次方*1次方
     * 3的4次方=3平方（二分递归）
     */
    public double Power2(double base, int exponent) {
        boolean isNegative = exponent < 0; // 是否是负指数
        double result = absPower(base, Math.abs(exponent));
        return isNegative ? 1 / result : result;
    }

    public double absPower(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double subResult = absPower(base, exponent / 2);
        return exponent % 2 != 0 ? subResult * subResult * base : subResult * subResult;
    }

    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _012_Power clazz = new _012_Power();
        System.out.println(clazz.Power2(2, 7));
    }
}




