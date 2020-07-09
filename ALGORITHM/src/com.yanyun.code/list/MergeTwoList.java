package com.yanyun.code.list;

import java.util.Arrays;

/**
 * @Auther: xcai
 * @Date: 2020/07/08/16:17
 * @Description:
 * @Version: 1.0
 * @优化 可以直接比较到最大的，然后整个插入
 */
public class MergeTwoList {
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 4, 6, 7, 123, 411, 5334, 1414141, 1314141414};
        int[] num2 = new int[]{0, 2, 5, 7, 89, 113, 5623, 6353, 134134};
        //俩个指针分别指向俩个数组头；
        int a = 0, b = 0;
        int[] num3 = new int[num1.length + num2.length];

        for (int i = 0; i < num3.length; i++) {
            //若均未遍历完
            if (a < num1.length && b < num2.length) {
                if (num1[a] > num2[b]) {
                    num3[i] = num2[b];
                    b++;
                } else {
                    num3[i] = num1[a];
                    a++;
                }
            } else if (a < num1.length) {
                num3[i] = num1[a];
                a++;
            } else if (b < num2.length) {
                num3[i] = num2[b];
                b++;
            }
        }
        System.out.println("排序后:" + Arrays.toString(num3));
    }
}
