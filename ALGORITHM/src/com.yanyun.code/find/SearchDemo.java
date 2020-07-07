package com.yanyun.code.find;

import com.yanyun.code.find.BinarySearch;
import com.yanyun.code.sort.MyArray;
import com.yanyun.code.sort.QuickSort;

import java.util.Arrays;

/**
 * @Auther: xcai
 * @Date: 2020/07/06/20:06
 * @Description:
 * @Version: 1.0
 */
public class SearchDemo {
    public static void main(String[] args) {

        System.out.println("【无序数组】-------");
        System.out.println(Arrays.toString(MyArray.array) + "\n");
        //快速排序
        System.out.println("【快速排序】-------");
        int[] array3 = MyArray.array.clone();
        long begin3 = System.currentTimeMillis();
        QuickSort.sort(array3);
        long end3 = System.currentTimeMillis();
        System.out.println(Arrays.toString(array3));
        System.out.println(String.format("花费时间：%sms", end3 - begin3) + "\n");

        //折半查找
        System.out.println("【折半查找】查询46-------");
        int search = BinarySearch.search(array3, 44);
        System.out.println("【折半查找】46的key：" + search);
    }
}
