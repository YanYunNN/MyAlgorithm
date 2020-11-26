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
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            // 最上面一行
            for (int col = left; col <= right; col++) {
                list.add(matrix[up][col]);
            }
            // 向下逼近
            up++;
            // 判断是否越界
            if (up > down) {
                break;
            }
            // 最右边一行
            for (int row = up; row <= down; row++) {
                list.add(matrix[row][right]);
            }
            // 向左逼近
            right--;
            // 判断是否越界
            if (left > right) {
                break;
            }
            // 最下面一行
            for (int col = right; col >= left; col--) {
                list.add(matrix[down][col]);
            }
            // 向上逼近
            down--;
            // 判断是否越界
            if (up > down) {
                break;
            }
            // 最左边一行
            for (int row = down; row >= up; row--) {
                list.add(matrix[row][left]);
            }
            // 向右逼近
            left++;
            // 判断是否越界
            if (left > right) {
                break;
            }
        }
        return list;
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
    }
}




