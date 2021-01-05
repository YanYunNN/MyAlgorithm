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
    /**
     * DP[i] = max{DP[i-1] + A[i],A[i]}
     * @return
     */
    static int maxSubSum(int arr[]) {
        int temp = 0, max = Integer.MIN_VALUE;
        for (int i : arr) {
            temp += i;
            if (temp > max) {
                max = temp;
            }
            /*如果累加和出现小于0的情况，则和最大的子序列肯定不可能包含前面的元素，这时将累加和置0，从下个元素重新开始累加*/
            if (temp < 0) {
                temp = i;
            }
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
        maxSubList(arr);
        int maxSubSum = maxSubSum(arr);
        System.out.println(maxSubSum);
    }
}
