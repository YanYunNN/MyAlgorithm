package com.yanyun.sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _013_reOrderArray {
    /**
     * 奇数：if ((n & 1) == 1)
     * 余数：i %（2^n） = i & (n-1)
     */
    /**
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     *  int[] arr = {1, 2, 3, 4, 5, 6, 7};
     *  int[] reArr = {1, 3, 5, 7, 2, 4, 6};
     */
    /**
     * 内置方法暴力法
     * @param array
     */
    public void reOrderArray0(int[] array) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) list1.add(array[i]);
            else list2.add(array[i]);
        }
        list1.addAll(list2);
        for (int i = 0; i < array.length; i++) {
            array[i] = list1.get(i);
        }
    }

    /**
     * 循环暴力法
     * {
     * int[] arr0 = {1, 2, 3, 4, 5, 6, 7};
     * int[] arr1 = {1, 3, 2, 5, 4, 7, 6};
     * int[] arr2 = {1, 3, 5, 2, 7, 4, 6};
     * int[] arr3 = {1, 3, 5, 7, 2, 4, 6};
     * }
     * @param array
     */
    public void reOrderArray1(int[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - 1; i++) {
                int i1 = array[i] & 1;
                int i2 = array[i + 1] & 1;
                int tmp;
                if (i1 == 0 && i2 == 1) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * in-place法
     * {
     * int[] arr0 = {1, 2, 3, 4, 5, 6, 7};
     * int[] arr1 = {1, 3, 2, 4, 5, 6, 7};
     * int[] arr2 = {1, 3, 2, 5, 4, 6, 7};
     * int[] arr3 = {1, 3, 5, 2, 4, 6, 7};
     * int[] arr4 = {1, 3, 5, 2, 4, 7, 6};
     * int[] arr5 = {1, 3, 5, 2, 7, 4, 6};
     * int[] arr6 = {1, 3, 5, 7, 2, 4, 6};
     * }
     */
    public void reOrderArray(int[] array) {
        int m = 0;//in-place指针
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                //TODO 前移n位的交换
                int temp = array[i];
                for (int j = i; j > m; j--) {
                    array[j] = array[j - 1];
                }
                array[m++] = temp;//m指针置换并后移一位
            }
            System.out.println(Arrays.toString(array));
        }
    }

    public void reOrderArray4(int[] nums) {
        int p = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if ((nums[i] & 1) == 1) {
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p++] = tmp;
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _013_reOrderArray clazz = new _013_reOrderArray();
        int[] arr = {1, 2, 3, 3, 4, 5, 6, 7};
        int[] reArr = {1, 3, 3, 5, 7, 2, 4, 6};
        System.out.println(Arrays.equals(arr, reArr));
        clazz.reOrderArray4(arr);
        System.out.println(Arrays.equals(arr, reArr));
    }
}




