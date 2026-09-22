package org.leetcode.learning.Sorts.QuickSort;


import java.util.Arrays;

public class Main {

    static int count = 0;

    public static void swap(int[] array, int firstIndex, int secondIndex){
        int temp=array[firstIndex];
        array[firstIndex]=array[secondIndex];
        array[secondIndex]=temp;
    }
    private static int pivot(int[] array, int pivotIndex, int endIndex){
        int swapIndex=pivotIndex;
        for(int i=pivotIndex+1;i<=endIndex;i++){
            if(array[i]<array[pivotIndex]){
                swapIndex++;
                swap(array,swapIndex,i);
            }
        }
        swap(array,pivotIndex, swapIndex);
        return swapIndex;
    }
    public static void quickSortHelper(int[] array, int left, int right){
        if(left<right) {
            int pivotIndex = pivot(array, left, right);
            quickSortHelper(array, left, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, right);
        }
    }
    private static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length-1);
    }

    private static int fibonacci(int n) {
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i]=fib[i-1]+fib[i-2];
            count++;
        }
        return fib[n];
    }

    public static void main(String[] args) {

        int[] array={4,6,1,7,3,2,5};
        quickSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("result= "+fibonacci(40));
        System.out.println("Counter= "+count);
    }
}