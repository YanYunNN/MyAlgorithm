package com.yanyun.juc.collections;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/07/20/18:44
 * @description
 */
public class AsListTest {
    /**
     * Exception in thread "main" java.lang.UnsupportedOperationException
     * at java.util.AbstractList.add(AbstractList.java:148)
     * at java.util.AbstractList.add(AbstractList.java:108)
     * at com.yanyun.juc.collections.AsListTest.main(AsListTest.java:17)
     */
    public static void main(String[] args) {
        List<? extends Serializable> asList = Arrays.asList("1", 2, "3");
        List<String> stringList = Arrays.asList("1", "2", "3");
        stringList.add("4");
        System.out.println(stringList);
    }
}
