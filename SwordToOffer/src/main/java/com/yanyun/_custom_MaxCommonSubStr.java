package com.yanyun;

import java.util.Scanner;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/16/18:59
 * @description
 */
public class _custom_MaxCommonSubStr {

    //楼主这方面很容易理解，有了最大长度，子串也方便得到了
    public static void main(String[] args) {
        String s1 = "abcbced";
        String s2 = "acbcbcedfff";
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        int[][] dp = new int[ch1.length][ch2.length];
        int maxLen = 0, max = 0;
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if (ch1[i] == ch2[j]) {
                    dp[i][j] = i > 0 && j > 0 ? dp[i - 1][j - 1] + 1 : 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                    max = Math.max(max, Math.max(i, j));
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        String substring = s1.substring(max - maxLen, max);
        System.out.println("最大公共子串长度为：" + maxLen);
        System.out.println("最大公共子串为：" + substring);
    }
}
