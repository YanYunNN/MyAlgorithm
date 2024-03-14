package com.yanyun.custome;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/31/9:57
 * @description 题目描述
 * * 给定一个只包含大写英文字母的字符串S，要求你给出对S重新排列的所有不相同的排列数。
 * * 如：S为ABA，则不同的排列有ABA、AAB、BAA三种
 * * <p>
 * * 解题思路：先把每个字符当做唯一出现，再除去相同字母的排列次数
 * * 如ABA：
 * * A(3,3)/A(2,2)*A(1,1)
 */
public class _ctm_ReSortChars {
    public static void main(String[] args) {
        String a = "ABA";
        char[] chars = a.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            Integer num = map.getOrDefault(c, 0);
            map.put(c, num + 1);
        }
        int allSort = factorial(chars.length);
        for (char key : map.keySet()) {
            allSort = allSort / factorial(map.get(key));
        }
        System.out.println(allSort);
    }

    /**
     * Ann的求解
     */
    private static int factorial(int n) {
        return n == 1 ? 1 : n * factorial(n - 1);
    }
}
