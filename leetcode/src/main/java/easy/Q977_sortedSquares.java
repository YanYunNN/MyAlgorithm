package easy;

import java.util.Arrays;

/**
 * @author xcai
 * @date 2025/02/07
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class Q977_sortedSquares {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquares1(int[] nums) {
        int[] arr = new int[nums.length];
        int i = nums.length - 1;
        int l = 0, r = nums.length - 1;

        while (i >= 0) {
            if (nums[l] * nums[l] < nums[r] * nums[r]) {
                arr[i--] = nums[r] * nums[r];
                r--;
            } else {
                arr[i--] = nums[l] * nums[l];
                l++;
            }
        }
        return arr;
    }
}