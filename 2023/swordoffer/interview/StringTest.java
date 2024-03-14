package com.yanyun.code.interview;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/09/16/12:37
 * @description
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));

        Integer i = 10;
        Integer j = 10;
        Integer ii = 129;
        Integer jj = 129;
        System.out.println(ii == jj);
        System.out.println(i == j);

        System.out.println(1111 << 3);
    }
}
