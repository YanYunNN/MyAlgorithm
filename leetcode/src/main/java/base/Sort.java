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

}
