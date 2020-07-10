package com.yanyun.code.recursive;

import javax.sound.midi.Soundbank;

/**
 * @Auther: xcai
 * @Date: 2020/07/10/11:18
 * @Description:
 * @Version: 1.0
 */
public class StrReverse {

    public static void main(String[] args) {
        String origin = "abcba";
        System.out.println(origin);
        String reverse = reverse(origin);
        System.out.println(reverse);

        //判断回文
        if (origin.equals(reverse)) {
            System.out.println("是回文！");
        }
    }

    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
