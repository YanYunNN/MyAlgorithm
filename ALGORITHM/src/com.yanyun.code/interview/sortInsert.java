package com.yanyun.code.interview;

import java.util.LinkedList;

/**
 * @Auther: xcai
 * @Date: 2020/07/15/18:46
 * @Description: 保证LinkedList每次有序插入
 * @Version: 1.0
 */
public class sortInsert {
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        addList(3);
        addList(1);
        addList(2);
        addList(5);
        addList(4);
        System.out.println(list.toString());
    }

    /**
     * 保证有序插入
     */
    public static void addList(Integer e) {
        int index = 0;
        for (Integer i : list) {
            if (i < e) {
                index++;
            }
        }
        list.add(index, e);
    }
}
