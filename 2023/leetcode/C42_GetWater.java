package com.yanyun.code.leetcode;

import java.util.Stack;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/09/15/20:18
 * @description
 */

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针
// 👍 1653 👎 0
public class C42_GetWater {

    /**
     * 穷举暴力法
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int res = 0;
        // 遍历每个柱子
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0, rightMax = 0;
            // 计算当前柱子左侧的柱子中的最大高度
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            // 计算当前柱子右侧的柱子中的最大高度
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            // 结果中累加当前柱子顶部可以储水的高度，
            // 即 当前柱子左右两边最大高度的较小者 - 当前柱子的高度。
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

    /**
     * DP 动态规划
     * 每个柱子，我们都需要从两头重新遍历一遍求出左右两侧的最大高度，这里是有很多重复计算的，很明显最大高度是可以记忆化的，
     * 可以用数组边递推边存储，也就是常说的动态规划，DP。
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        int res = 0;
        int n = height.length;
        if (n == 0) {
            return res;
        }
        // 定义二维dp数组
        // dp[i][0] 表示下标i的柱子左边的最大值
        // dp[i][1] 表示下标i的柱子右边的最大值
        int[][] dp = new int[n][2];
        dp[0][0] = height[0];
        dp[n - 1][1] = height[n - 1];
        //0所在列无法蓄水
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(height[i], dp[i - 1][0]);
        }
        //n-1最后一列无法蓄水
        for (int i = n - 2; i >= 0; i--) {
            dp[i][1] = Math.max(height[i], dp[i + 1][1]);
        }
        // 遍历每个柱子,当前柱子左右两边最大高度的较小者 - 当前柱子的高度(短板原理)
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(dp[i][0], dp[i][1]) - height[i];
        }
        return res;
    }

    /**
     * 双指针
     * res += Math.min(dp[i][0], dp[i][1]) - height[i];
     * 优化成：
     * res += Math.min(leftMax, rightMax) - height[i];
     * leftMax 是从左端开始递推得到的，而 rightMax 是从右端开始递推得到
     * 遍历每个柱子，累加每个柱子的储水高度时，也需要用 left 和 right 两个指针从两端开始遍历
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int res = 0, leftMax = 0, rightMax = 0, left = 0, right = height.length - 1;
        int n = height.length;
        if (n == 0) {
            return res;
        }
        while (left <= right) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right--];
            }
        }
        return res;
    }

    /**
     * 单调栈【比普通的栈多一个性质，即维护栈内元素单调（增/减）】
     * 当前柱子如果小于等于栈顶元素，说明形不成凹槽，则将当前柱子入栈；
     * 反之若当前柱子大于栈顶元素，说明形成了凹槽，于是将栈中小于当前柱子的元素pop出来，将凹槽的大小累加到结果中
     * @param height
     * @return
     */
    public static int trap3(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int length = height.length;
        if (length == 0) {
            return res;
        }
        for (int i = 0; i < length; i++) {
            //若当前柱子大于栈顶元素，说明形成了凹槽，于是将栈中小于当前柱子的元素pop出来，将凹槽的大小累加到结果中
            while (!stack.empty() && height[stack.peek()] < height[i]) {
                int bottomIdx = stack.pop();
                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == height[bottomIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    // stack.peek() 是此次接住的雨水的左边界的位置，右边界是当前的柱体，即i。
                    // Math.min(height[stack.peek()], height[i]) 是左右柱子高度的min，减去height[bottomIdx]就是雨水的高度。
                    // i - stack.peek() - 1 是雨水的宽度。
                    res += (Math.min(height[stack.peek()], height[i]) - height[bottomIdx]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(height);
        int trap1 = trap1(height);
        int trap2 = trap2(height);
        int trap3 = trap3(height);
        System.out.println(trap == trap1);
        System.out.println(trap == trap2);
        System.out.println(trap == trap3);
    }

}
