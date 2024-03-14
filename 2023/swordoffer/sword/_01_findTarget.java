package com.yanyun.sword;

public class _01_findTarget {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean find = Find(7, array);
        System.out.println(find);
        boolean find1 = Find1(7, array);
        System.out.println(find1);
    }

    /**
     * 暴力法
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (target < array[i][j]) {
                    break;
                }
                if (target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 二分查找法
     * @param target
     * @param array
     * @return
     */
    public static boolean Find1(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;
        if (row == 0 || col == 0) {
            return false;
        }
        int r = 0, c = col - 1; // 右上角元素
        while (r < row && c >= 0) {
            if (target == array[r][c]) {
                return true;
            } else if (target > array[r][c]) {
                ++r;
            } else {
                --c;
            }
        }
        return false;
    }

}
