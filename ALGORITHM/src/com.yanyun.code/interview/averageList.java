package com.yanyun.code.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xcai
 * @Date: 2020/07/15/19:48
 * @Description: 将一个list均分成n个list, 主要通过偏移量来实现的
 * @Version: 1.0
 */
public class averageList<T> {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        averageList<String> averageList = new averageList<>();
        List<List<String>> lists = averageList.splitList(list, 3);
        System.out.println(lists);

        List<List<String>> lists1 = averageAssign(list, 3);
        System.out.println(lists1);
    }

    public List<List<T>> splitList(List<T> list, int n) {
        if (list == null || list.size() == 0 || n < 1) {
            return null;
        }
        List<List<T>> result = new ArrayList<>();
        //总长度
        int size = list.size();
        //分几份
        int count = (size + n - 1) / n;
        for (int i = 0; i < count; i++) {
            List<T> subList = list.subList(i * n, (Math.min((i + 1) * n, size)));
            result.add(subList);
        }
        return result;
    }

    public static <T> List<List<T>> averageAssign(List<T> list, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        int remaider = list.size() % n;  //(先计算出余数)
        int number = list.size() / n;  //然后是商
        int offset = 0;//偏移量
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remaider > 0) {
                value = list.subList(i * number + offset, (i + 1) * number + offset + 1);
                remaider--;
                offset++;
            } else {
                value = list.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }
}
