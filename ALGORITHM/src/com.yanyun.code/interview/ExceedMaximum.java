package com.yanyun.code.interview;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/09/17/13:27
 * @description
 */
public class ExceedMaximum {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE * 2;
        System.out.println(a);
        int b = Integer.MAX_VALUE << 1;
        System.out.println(b);

        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE * 2));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE << 1));

        System.out.println(Integer.parseInt("1111111111111111111111111111110",2));
        System.out.println(Integer.parseInt("111111111111111111111111111110",2));
        System.out.println(Integer.parseInt("111111111111111111111111111111",2));
    }
}
