package com.yanyun.leetcode;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/24/20:17
 * @description 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 K = 2
 * <p> 滑动窗口
 * 【1】,1,1,0,0,0,1,1,1,1,0
 * 【1,1】,1,0,0,0,1,1,1,1,0
 * 【1,1,1】,0,0,0,1,1,1,1,0
 * 【1,1,1,0】,0,0,1,1,1,1,0 zero++
 * 【1,1,1,0,0】,0,1,1,1,1,0 zero++
 * 【1,1,1,0,0,0】,1,1,1,1,0 zero==3 > K 此时左指针++，一直移动到下一个0，的位置
 * 1,1,1,0,【0,0】,1,1,1,1,0
 * 1,1,1,0,【0,0,1】,1,1,1,0
 * 1,1,1,0,【0,0,1,1】,1,1,0
 * 1,1,1,0,【0,0,1,1,1】,1,0
 * 1,1,1,0,【0,0,1,1,1,1】,0
 * 1,1,1,0,【0,0,1,1,1,1,0】 zero ==3 > K 此时左指针++
 * 1,1,1,0,0,【0,1,1,1,1,0】
 */
public class _1004_longestOnes {
    public static int longestOnes0(int[] A, int K) {
        int left = 0, right = 0;
        int zero = 0, max = 0;
        while (right < A.length) {
            if (A[right++] == 0) {
                zero++;
            }
            while (zero > K) {
                if (A[left++] == 0) {
                    zero--;
                }
            }
            max = Math.max(right - left, max);
        }
        return max;
    }

    public static int longestOnes(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1};
        int[] B = {1, 1, 1, 0, 0, 0};
        int[] C = {1, 1, 1, 0};
        int longestOnes = longestOnes0(C, 2);
        int longestOnes1 = longestOnes(C, 2);
        System.out.println(longestOnes);
        System.out.println(longestOnes1);
    }
}
