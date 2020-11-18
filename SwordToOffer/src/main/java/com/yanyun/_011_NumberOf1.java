package com.yanyun;

public class _011_NumberOf1 {
    /**
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
     * 10-2;
     */
    //利用与
    //1100&1011=1000. 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;//n = n & (n-1)
        }
        return count;
    }

    //利用与
    public int NumberOf2(int n) {
        int num = 0, flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                num++;
            }
            flag <<= 1;
        }
        return num;
    }

    //利用 & -1 （0xffffffff）
    //11111111 11111111 11111111 11111111
    public int NumberOf3(int n) {
        int num = 0;
        if (n < 0) {
            n = n & 0xffffffff;// n = n & -1;
        }
        char[] chars = Integer.toBinaryString(n).toCharArray();
        for (char aChar : chars) {
            if (aChar == '1') {
                num++;
            }
        }
        return num;
    }

    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _011_NumberOf1 clazz = new _011_NumberOf1();
        System.out.println(clazz.NumberOf1(101));
        System.out.println(clazz.NumberOf2(10));
        System.out.println(clazz.NumberOf3(10));
    }
}




