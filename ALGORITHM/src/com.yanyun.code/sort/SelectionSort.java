package com.yanyun.code.sort;

/**
 * @Auther: xcai
 * @Date: 2020/07/06/20:34
 * @Description:表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。
 * @算法描述 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 * @算法分析 最佳情况：T(n) = O(n2) 最差情况：T(n) = O(n2) 平均情况：T(n) = O(n2)
 * @Version: 1.0
 */
public class SelectionSort {
    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int sort(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        int n = 0;
        //其他都排好了，最后一个不用排
        for (int i = 0; i < array.length - 1; i++) {
            //保存最小索引
            int minIndex = i;
            //从i后面一个数再排，分割成有序和无序区
            for (int j = i + 1; j < array.length; j++) {
                //找到最小的数
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                n++;
            }
            if (i != minIndex) {
                MyArray.swap(array, i, minIndex);
            }
        }
        return n;
    }
}
