package com.yanyun;

import java.util.*;

/**
 * 回旋矩阵的打印
 */
public class _019_printMatrix {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字例如，如果输入如下4 X 4矩阵：
     * 1   2  3  4
     * 5   6  7  8
     * 9  10 11 12
     * 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
     * <p>
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * <p>
     * 递归
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        return list;
    }


    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _019_printMatrix clazz = new _019_printMatrix();
        ArrayList<Integer> list = clazz.printMatrix(matrix);
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * --------------------------------------------------INIT-----------------------------------------------------------
     */
    private static int[][] matrix;

    static {
        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    }
}




