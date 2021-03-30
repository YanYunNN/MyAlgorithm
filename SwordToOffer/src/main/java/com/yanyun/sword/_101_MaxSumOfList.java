package com.yanyun.sword;

/**
 * @author xcai
 * @version 1.0
 * @date 2021/01/05/11:34
 * @description 求连续子数组的最大和问题
 * {2,4,-7,5,2,-1,2,-4,3}的最大连续子数组为{5,2,-1,2}，
 * 最大连续子数组的和为5+2-1+2=8。
 */
public class _101_MaxSumOfList {
    public static int maxSubArray(int[] nums) {
        // 创建dp；初始化
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = dp[0];
        // 外层for，状态步进；dp[i]代表以该元素为右端的最大子数组（最优子问题）
        for (int i = 1; i < dp.length; i++) {
            // 内层for，状态转移，两路择优
            if (dp[i - 1] > 0) dp[i] = nums[i] + dp[i - 1];
            else dp[i] = nums[i];

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {     // 若当前遍历到num，sum是以num为右端的最大子数组和
            if (sum > 0) sum += num;
            else sum = num;
            max = Math.max(max, sum);
        }
        return max;
    }
//    原文链接：https://blog.csdn.net/weixin_43969686/article/details/104963542

    /**
     * DP[i] = max{DP[i-1] + A[i],A[i]}
     * @return
     */
    static int maxSubSum(int arr[]) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i : arr) {
            sum += i;
            /*如果累加和出现小于0的情况，则和最大的子序列肯定不可能包含前面的元素，这时将累加和置0，从下个元素重新开始累加*/
            if (sum < 0) {
                sum = i;
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    static int maxSubList(int arr[]) {
        int temp = 0, max = Integer.MIN_VALUE;
        int start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            temp += arr[i];
            /*如果累加和出现小于0的情况，则和最大的子序列肯定不可能包含前面的元素，这时将累加和置0，从下个元素重新开始累加*/
            if (temp < 0) {
                temp = arr[i];
                start = i;
            }
            if (temp > max) {
                max = temp;
                end = i;
            }
        }
        System.out.println("start:" + start + ";end:" + end);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, -7, 5, 2, -1, 2, -4, 3};
        System.out.println(arr);
//        maxSubArray(arr);
        maxSubList(arr);
        int maxSubSum = maxSubSum(arr);
        System.out.println(maxSubSum);
    }
}
