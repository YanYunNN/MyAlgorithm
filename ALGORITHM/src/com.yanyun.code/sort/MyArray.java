package com.yanyun.code.sort;

/**
 * @Auther: xcai
 * @Date: 2020/07/06/20:01
 * @Description:
 * @Version: 1.0
 */
public class MyArray implements Cloneable {
    /**
     * 乱序数组
     */
    public final static int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 交换ab
     * @param array
     * @param j
     * @param i
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
