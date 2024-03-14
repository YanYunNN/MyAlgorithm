package com.yanyun.code.sort;

/**
 * @Auther: xcai
 * @Date: 2020/07/06/19:58
 * @Description: 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，依次比较两个元素，如果它们的顺序错误就把它们交换过来。
 * @算法描述 比较相邻的元素。如果第一个比第二个大，就交换它们两个；对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * @算法分析 最佳情况：T(n) = O(n) 最差情况：T(n) = O(n2) 平均情况：T(n) = O(n2)
 * @Version: 1.0
 */
public class BubbleSort {
    public static int sort(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        // 外层循环控制比较轮数i
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            // 内层循环控制每一轮比较次数，每进行一轮排序都会找出一个较大值
            //array.length-1防止越界
            //array.length-1-i是为了减少没必要的后续比较，提高效率
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    MyArray.swap(array, j, j + 1);
                    n++;
                }
            }
        }
        return n;
    }
}
