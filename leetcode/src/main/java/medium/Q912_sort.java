package medium;

import java.util.Random;

public class Q912_sort {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = partition(nums, left, right); //partition分区函数，mid为填好坑的值
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pos = left + new Random().nextInt(right - left + 1);
        swap(nums, pos, right);

        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= nums[right]) {  //nums[right]=pivot
                swap(nums, ++i, j); //小于pivot的值放左边
            }
        }
        swap(nums, i + 1, right); //i+1左边都是小于的值，因此i+1就是最终归属的位置
        return i + 1;
    }

    private int partition1(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) --right; //从右向左扫描数组，寻找一个小于枢轴的元素
            nums[left] = nums[right]; //将找到的小于枢轴的元素放到左边的位置
            while (left < right && nums[right] <= pivot) ++left; //从左向右扫描数组，寻找一个大于枢轴的元素
            nums[right] = nums[left]; //将找到的大于枢轴的元素放到右边的位置
        }
        nums[left] = pivot; //左边的所有元素都小于等于枢轴，右边的所有元素都大于等于枢轴
        return left;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
