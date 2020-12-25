package com.yanyun.custome;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/25/9:45
 * @description 测试MAX MIN
 */
public class _ctm_MAX_MIN {
    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        System.out.println(maxValue + 1);
        System.out.println(maxValue + maxValue);//max+1 + max +1 -2 = 0 -2 = -2
        System.out.println(minValue - 1);
        System.out.println(minValue + minValue);

        System.out.println(Integer.toBinaryString(minValue));
        System.out.println(Integer.toBinaryString(maxValue));
        System.out.println((maxValue + 1) == minValue);
    }

}
