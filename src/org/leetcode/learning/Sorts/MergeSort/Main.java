package org.leetcode.learning.Sorts.MergeSort;


import java.util.Arrays;
import org.leetcode.learning.LinkedList.LinkedList;

public class Main {
    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;

        int midIndex = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, midIndex, arr.length));

        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] arr, int[] arr2) {
        int[] newArr = new int[arr.length + arr2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < arr.length && j < arr2.length) {
            if (arr[i] < arr2[j]) {
                newArr[index] = arr[i];
                i++;
            } else {
                newArr[index] = arr2[j];
                j++;
            }
            index++;
        }
        while (i < arr.length) {
            newArr[index] = arr[i];
            i++;
            index++;
        }
        while (j < arr2.length) {
            newArr[index] = arr2[j];
            j++;
            index++;
        }
        return newArr;
    }


    public static void main(String[] args) {

//        int[] arr = {2, 1,4, 3};
//        System.out.println(Arrays.toString(mergeSort(arr)));
        LinkedList l1 = new LinkedList(1);
        l1.append(3);
        l1.append(5);
        l1.append(7);

        LinkedList l2 = new LinkedList(2);
        l2.append(4);
        l2.append(6);
        l2.append(8);

        l1.mergeSort(l2);
        l1.printList();

    }
}