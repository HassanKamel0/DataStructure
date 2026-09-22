package org.leetcode.learning.Sorts.BubbleSort;


import java.util.Arrays;

public class Main {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {4,2,6,5,1,3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}