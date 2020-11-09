package com.yanyun;

public class _02_replaceSpace {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        String s = replaceSpace2(str);
        System.out.println(s);
    }

    /**
     * 暴力法
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

    /**
     * 遍历法
     * @param str
     * @return
     */
    public static String replaceSpace1(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String replaceSpace2(StringBuffer str) {
        return str.toString();
    }
}
