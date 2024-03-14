package com.yanyun.code.interview;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/11/15/9:56
 * @description
 */
@Data
public class SPU {
    List<List<String>> properties;

    /**
     * -----------------------------------------------init--------------------------------------------------------------
     */
    private final static SPU spu = new SPU();
    private static List<String> addList = new ArrayList<>();

    static {
        List<List<String>> lists = new ArrayList<>();
        List<String> innerList1 = Arrays.asList("a", "b", "c", "d");
        List<String> innerList2 = Arrays.asList("1", "2", "3", "4");
        lists.add(innerList1);
        lists.add(innerList2);
        spu.setProperties(lists);
    }

    /**
     * -----------------------------------------------main--------------------------------------------------------------
     */
    public static void main(String[] args) {
        List<List<String>> properties = spu.properties;
        System.out.println(JSON.toJSON(properties));
    }
}

