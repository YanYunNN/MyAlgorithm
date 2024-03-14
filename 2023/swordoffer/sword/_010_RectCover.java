package com.yanyun.sword;

public class _010_RectCover {
    /**
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * 用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
     * 3-3;4-5
     */
    //递推法
    public int RectCover(int n) {
        if (n <= 3) return n;
        return RectCover(n - 1) + RectCover(n - 2);
    }


    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _010_RectCover clazz = new _010_RectCover();
        System.out.println(clazz.RectCover(4));
    }
}




