package com.yanyun.code.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/09/21/12:21
 * @description 回旋遍历
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5,},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
        int[][] matrix1 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        List<Integer> result = spiralOrder(matrix);
        System.out.println(Arrays.toString(result.toArray()));
        List<Integer> result1 = spiralOrder(matrix1);
        System.out.println(Arrays.toString(result1.toArray()));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < (Math.min(m, n) + 1) / 2; i++) {
            //上边
            for (int j = i; j < n - i; j++) {
                list.add(matrix[i][j]);
            }
            //右边
            for (int j = i + 1; j < m - i; j++) {
                list.add(matrix[j][(n - 1) - i]);
            }
            //下边
            for (int j = i + 1; j < n - i; j++) {
                list.add(matrix[m - 1 - i][n - 1 - j]);
            }
            //左边
            for (int j = i + 1; j < m - 1 - i; j++) {
                list.add(matrix[m - 1 - j][i]);
            }
        }
        return list;
    }
}
