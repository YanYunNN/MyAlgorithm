package com.yanyun.code.interview;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Sets;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/11/15/9:56
 * @description
 */

public class SPUTest {
    @Data
    public class Property {
        // 属性code，唯一标识
        String AttrCode;
        // 值域列表
        List<String> ValueCodes;
    }

    //     p1s: []Property{
    //         {
    //             AttrCode:   "V1",
    //             ValueCodes: []string{"V1_1"},
    //         },
    //     },
    //     p2s: []Property{
    //         {
    //             AttrCode:   "V1",
    //             ValueCodes: []string{"V1_1"},
    //         },
    //     },
    //     wantErr: false,
    // },
    // {
    //     p1s: []Property{
    //         {
    //             AttrCode:   "V1",
    //             ValueCodes: []string{"V1_1"},
    //         },
    //     },
    //     p2s: []Property{
    //         {
    //             AttrCode:   "V1",
    //             ValueCodes: []string{"V1_1", "V1_2"},
    //         },
    //     },
    //     wantErr: false,
    // },
    // {
    //     p1s: []Property{
    //         {
    //             AttrCode:   "V1",
    //             ValueCodes: []string{"V1_1"},
    //         },
    //         {
    //             AttrCode:   "V2",
    //             ValueCodes: []string{"V2_1"},
    //         },
    //     },
    //     p2s: []Property{
    //         {
    //             AttrCode:   "V1",
    //             ValueCodes: []string{"V1_1"},
    //         },
    //     },
    //     wantErr: true,
    // },
    // {
    //     p1s: []Property{
    //         {
    //             AttrCode:   "V1",
    //             ValueCodes: []string{"V1_1"},
    //         },
    //     },
    //     p2s: []Property{
    //         {
    //             AttrCode:   "V2",
    //             ValueCodes: []string{"V2_1"},
    //         },
    //     },
    //     wantErr: true,
    // }

    /**
     * 需求：已有属性值域可添加，不可删减；
     * p1 是数据库中数据，p2 是用户提交数据，返回 p2 是否符合需求
     */
    public Boolean solution(List<Property> p1, List<Property> p2) {
        Set<Integer> sets = Sets.newHashSet(1, 2, 3, 4, 5, 6);
        Set<Integer> sets2 = Sets.newHashSet(3, 4, 5, 6, 7, 8, 9);
        Sets.SetView<Integer> intersection = Sets.intersection(sets, sets2);
        return false;

    }
}


