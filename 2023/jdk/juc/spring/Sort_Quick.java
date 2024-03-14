package com.yanyun.spring;

import java.util.Arrays;

/**
 * @author xcai
 * @version 1.0
 * @date 2021/04/11/19:55
 * @description
 */
public class Sort_Quick {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 5, 8, 9};
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
            System.out.println(Arrays.toString(array));
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = low;
        int p = low, q = high;
        while (p < q) {
            while (p < q && array[pivot] <= array[q]) {
                q--;
            }
            while (p < q && array[pivot] >= array[p]) {
                p++;
            }
            swap(array, p, q);
        }
        swap(array, pivot, p);
        return pivot;
    }

    private static void swap(int[] array, int p, int q) {
        int temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }

}
