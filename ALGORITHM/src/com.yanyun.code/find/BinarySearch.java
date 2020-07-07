package com.yanyun.code.find;

/**
 * @Auther: xcai
 * @Date: 2020/07/06/21:55
 * @Description: 二分查找
 * https://blog.csdn.net/ThinkWon/article/details/105870730
 * @Version: 1.0
 * 二分查找也称折半查找（Binary Search），它是一种效率较高的查找方法，前提是数据结构必须先排好序，时间复杂度可以表示O(h)=O(log2n)，以2为底，n的对数。
 * 其缺点是要求待查表为有序表，且插入删除困难。
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50};

    }

    public static int search(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        //防止越界
        if (key < array[low] || key > array[high] || low > high) {
            return -1;
        }
        //二分搜索
        while (low <= high) {
            //采用移位运算
            //mid=(low + high)/2 ，极端情况下，(low + high)存在着溢出的风险，进而得到错误的mid结果，导致程序错误。
            //算法二能保证计算出来的mid，一定大于low，小于high，不存在溢出的问题
            mid = (low + high) >>> 1;
            System.out.println(String.format("low:%s,mid:%s,high:%s", low, mid, high));
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
