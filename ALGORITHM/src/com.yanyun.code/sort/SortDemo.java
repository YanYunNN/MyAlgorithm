package com.yanyun.code.sort;

import java.util.Arrays;

/**
 * @Auther: xcai
 * @Date: 2020/07/06/20:06
 * @Description:
 * @Version: 1.0
 */
public class SortDemo {
    public static void main(String[] args) {


        System.out.println("【无序数组】-------");
        System.out.println(Arrays.toString(MyArray.array) + "\n");

        //冒泡排序
        System.out.println("【冒泡排序】-------");
        int[] array1 = MyArray.array.clone();
        long begin1 = System.currentTimeMillis();
        int sortTime1 = BubbleSort.sort(array1);
        long end1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(array1));
        System.out.println(String.format("比较次数：%d,花费时间：%sms", sortTime1, end1 - begin1) + "\n");

        //选择排序
        System.out.println("【选择排序】-------");
        int[] array2 = MyArray.array.clone();
        long begin2 = System.currentTimeMillis();
        int sortTime2 = SelectionSort.sort(array2);
        long end2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(array2));
        System.out.println(String.format("比较次数：%d,花费时间：%sms", sortTime2, end2 - begin2) + "\n");

        //快速排序
        System.out.println("【快速排序】-------");
        int[] array3 = MyArray.array.clone();
        long begin3 = System.currentTimeMillis();
        QuickSort.sort(array3);
        long end3 = System.currentTimeMillis();
        System.out.println(Arrays.toString(array3));
        System.out.println(String.format("花费时间：%sms", end3 - begin3) + "\n");

    }
}
