package com.yanyun;

public class _06_minNumberInRotateArray {
    /**
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * 遇到数组 ---> 双指针
     * <p>
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * <INPUT>
     * [3,4,5,1,2]  // 12345 -> 345 12
     * <OUTPUT>
     * 1
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        int low = 0, high = array.length - 1;

        while (low < high) {
            if (array[low] < array[high]) {
                return array[low];
            }
            int mid = low + (high - low) / 2;
            if (array[low] < array[mid]) {
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            } else {
                low++;
            }
        }
        return array[low];
    }


    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _06_minNumberInRotateArray clazz = new _06_minNumberInRotateArray();
        int[] array = new int[]{4, 4, 5, 6, 0, 1, 2, 3, 4};
        int i = clazz.minNumberInRotateArray(array);
        System.out.println(i);
    }
}




