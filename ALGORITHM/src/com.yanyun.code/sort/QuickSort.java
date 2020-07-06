package com.yanyun.code.sort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

/**
 * @Auther: xcai
 * @Date: 2020/07/06/20:51
 * @Description: 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序
 * @算法描述 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）
 * @1. 从数列中挑出一个元素，称为 “基准”（pivot）；
 * @2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * @3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * @算法分析 T(n) = O(nlogn) 最差情况：T(n) = O(n2) 平均情况：T(n) = O(nlogn)
 * @Version: 1.0 https://blog.csdn.net/shujuelin/article/details/82423852
 */
public class QuickSort {
    /**
     * 快速排序
     * @param array
     * @return
     */
    public static void sort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    /**
     * 递归遍历
     */
    private static void quicksort(int[] array, int left, int right) {
        if (array == null || left >= right || array.length <= 1) {
            return;
        }
        //找到基准点（找个一个元素放在正确的位置上）
        int pivot = partition(array, left, right);
        quicksort(array, left, pivot - 1);
        quicksort(array, pivot + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        //temp:基准位，每个分区要设为基准点的头元素；
        int index = left;
        int temp = array[left];
        while (left < right) {
            //先看右边，依次往左递减
            while (temp <= array[right] && left < right) {
                right--;
            }
            //再看左边，依次往右递增
            while (temp >= array[left] && left < right) {
                left++;
            }
            //如果满足条件则交换
            if (left < right) {
                MyArray.swap(array, left, right);
            }
        }
        //最后将基准位与i和j相等位置的数字交换,right/left一个下标
        MyArray.swap(array, index, right);
        return right;
    }
}
