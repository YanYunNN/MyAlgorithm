package base;

import java.util.Arrays;

public class Sort {
    /**
     * @param values
     * @see <a href='https://blog.csdn.net/rej177/article/details/124329753'>csdn<a/>
     */
    public static void bubbleSort(int[] values) {
        int temp;
        for (int i = 0; i < values.length; i++) {
            boolean flag = true;
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (values[j] > values[j + 1]) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            System.out.println("第" + (i + 1) + "趟的输出结果：" + Arrays.toString(values));
        }
        System.out.println("排完序的序列：" + Arrays.toString(values));
    }

    public static void simpleSwapSort(int[] nums) {
        //进行 k 趟排序
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
            System.out.println("第" + (i + 1) + "趟的输出结果：" + Arrays.toString(nums));
        }
        System.out.println("排完序的序列：" + Arrays.toString(nums));
    }

    class QuickSort {
        /**
         * 快速排序，挖坑法
         */
        public int[] quickSort1(int[] arr) {
            partition1(arr, 0, arr.length - 1);
            return arr;
        }

        public void partition1(int arr[], int left, int right) {
            if (left > right) {
                return;
            }
            //pivot 为基准值，arr [left] 赋值给 pivot 后，空出来相当于挖了个坑
            int pivot = arr[left];
            int i = left, j = right;
            while (i < j) {
                // 找到小于基准值的 arr [j]
                while (i < j && arr[j] >= pivot) {
                    j--;
                }
                if (i < j) {
                    // 挖坑，arr [j] 空出来，相当于挖了个坑
                    // 也可以理解为 arr [i] 挖的坑 arr [j] 填上
                    // 第一次循环时，i = 0，就是基准值所在地
                    // 所以第一个被填上的坑一定是在基准值处挖的坑
                    arr[i] = arr[j];
                    i++;
                }
                // 找到大于基准值的 arr [i]
                while (i < j && arr[i] <= pivot) {
                    i++;
                }
                if (i < j) {
                    // 填坑，arr [j] 挖的坑，arr [i] 填上
                    // 也可以理解为 arr [i] 挖了一个坑
                    arr[j] = arr[i];
                    j--;
                }
            }
            //i 和 j 相等时，将基准值填到 arr [i]
            // 这时 arr [i] 左边的数字都比它小，右边的数字都比它大
            arr[i] = pivot;
            // 递归处理左半数组
            partition1(arr, left, i - 1);
            // 递归处理右半数组
            partition1(arr, i + 1, right);
        }

        /**
         * 快速排序，交换法
         */
        public int[] quickSort2(int[] arr) {
            partition2(arr, 0, arr.length - 1);
            return arr;
        }

        public void partition2(int[] arr, int left, int right) {
            if (left < right) {
                return;
            }
            // 基准值
            int pivot = arr[left];
            int i = left, j = right, temp;
            while (i < j) {
                // 找到小于基准值的 arr [j]
                while (i < j && arr[j] >= pivot) {
                    j--;
                }
                // 找到大于基准值的 arr [i]
                while (i < j && arr[i] <= pivot) {
                    i++;
                }
                // 大于基准值的 arr [i] 和小于基准值的 arr [j] 交换
                if (i < j) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // 最后将基准值位置的数字（基准值）与 i,j 相等位置的数字交换
            arr[left] = arr[i];
            arr[i] = pivot;
            // 递归处理左半数组
            partition2(arr, left, i - 1);
            // 递归处理右半数组
            partition2(arr, i + 1, right);
        }
    }

}
