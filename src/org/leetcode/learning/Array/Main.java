package org.leetcode.learning.Array;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Test case 1
//        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int val1 = 1;
//        int newLength1 = removeElement(nums1, val1);
//        System.out.println("Test case 1: Modified array: " +
//                Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)) +
//                "\nNew length: " + newLength1);
//
//        // Test case 2
//        int[] nums2 = {1, 2, 3, 4, 5, 6};
//        int val2 = 6;
//        int newLength2 = removeElement(nums2, val2);
//        System.out.println("Test case 2: Modified array: " +
//                Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)) +
//                "\nNew length: " + newLength2);
//
//        // Test case 3
//        int[] nums3 = {-1, -2, -3, -4, -5};
//        int val3 = -1;
//        int newLength3 = removeElement(nums3, val3);
//        System.out.println("Test case 3: Modified array: " +
//                Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3)) +
//                "\nNew length: " + newLength3);
//
//        // Test case 4
//        int[] nums4 = {};
//        int val4 = 1;
//        int newLength4 = removeElement(nums4, val4);
//        System.out.println("Test case 4: Modified array: " +
//                Arrays.toString(Arrays.copyOfRange(nums4, 0, newLength4)) +
//                "\nNew length: " + newLength4);
//
//        // Test case 5
//        int[] nums5 = {1, 1, 1, 1, 1};
//        int val5 = 1;
//        int newLength5 = removeElement(nums5, val5);
//        System.out.println("Test case 5: Modified array: " +
//                Arrays.toString(Arrays.copyOfRange(nums5, 0, newLength5)) +
//                "\nNew length: " + newLength5);


        int[] myList1 = {5, 3, 8, 1, 6, 9};
        int[] result1 = findMaxMin(myList1);
        System.out.println("Test case 1: MaxMin: " + Arrays.toString(result1)); // prints "[9, 1]"

        int[] myList2 = {-5, -3, -8, -1, -6, -9};
        int[] result2 = findMaxMin(myList2);
        System.out.println("Test case 2: MaxMin: " + Arrays.toString(result2)); // prints "[-1, -9]"

        int[] myList3 = {0, 0, 0, 0, 0};
        int[] result3 = findMaxMin(myList3);
        System.out.println("Test case 3: MaxMin: " + Arrays.toString(result3)); // prints "[0, 0]"

        int[] myList4 = {100, 200, 300, 400, 500};
        int[] result4 = findMaxMin(myList4);
        System.out.println("Test case 4: MaxMin: " + Arrays.toString(result4)); // prints "[500, 100]"


        String[] stringList1 = {"apple", "banana", "kiwi", "pear"};
        String longest1 = findLongestString(stringList1);
        System.out.println("Test case 1: Longest string: " + longest1);  // prints "banana"

        String[] stringList2 = {"cat", "giraffe", "elephant", "hippopotamus"};
        String longest2 = findLongestString(stringList2);
        System.out.println("Test case 2: Longest string: " + longest2);  // prints "hippopotamus"

        String[] stringList3 = {"sun", "moon", "planet", "universe"};
        String longest3 = findLongestString(stringList3);
        System.out.println("Test case 3: Longest string: " + longest3);  // prints "universe"

        String[] stringList4 = {"java", "python", "javascript", "c"};
        String longest4 = findLongestString(stringList4);
        System.out.println("Test case 4: Longest string: " + longest4);  // prints "javascript"

        String[] stringList5 = {"", "a", "aa", "aaa"};
        String longest5 = findLongestString(stringList5);
        System.out.println("Test case 5: Longest string: " + longest5);  // prints "aaa"


//        int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int newLength1 = removeDuplicates(nums1);
//        System.out.println("Test case 1: New length: " + newLength1);
//        System.out.println("Test case 1: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)));
//
//        int[] nums2 = {1, 1, 2};
//        int newLength2 = removeDuplicates(nums2);
//        System.out.println("Test case 2: New length: " + newLength2);
//        System.out.println("Test case 2: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)));
//
//        int[] nums3 = {-1, 0, 0, 0, 3, 3};
//        int newLength3 = removeDuplicates(nums3);
//        System.out.println("Test case 3: New length: " + newLength3);
//        System.out.println("Test case 3: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3)));
//
//        int[] nums4 = {};
//        int newLength4 = removeDuplicates(nums4);
//        System.out.println("Test case 4: New length: " + newLength4);
//        System.out.println("Test case 4: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums4, 0, newLength4)));
//
//        int[] nums5 = {1, 1, 1, 1, 1};
//        int newLength5 = removeDuplicates(nums5);
//        System.out.println("Test case 5: New length: " + newLength5);
//        System.out.println("Test case 5: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums5, 0, newLength5)));


        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int profit1 = maxProfit(prices1);
        System.out.println("Test case 1: Maximum profit: " + profit1); // prints "Maximum profit: 5"

        int[] prices2 = {7, 6, 5, 4, 3, 2, 1};
        int profit2 = maxProfit(prices2);
        System.out.println("Test case 2: Maximum profit: " + profit2); // prints "Maximum profit: 0"

        int[] prices3 = {1, 2, 3, 4, 5, 6, 7};
        int profit3 = maxProfit(prices3);
        System.out.println("Test case 3: Maximum profit: " + profit3); // prints "Maximum profit: 6"

        int[] prices4 = {3, 2, 6, 5, 0, 3};
        int profit4 = maxProfit(prices4);
        System.out.println("Test case 4: Maximum profit: " + profit4); // prints "Maximum profit: 4"

        int[] prices5 = {2, 4, 1};
        int profit5 = maxProfit(prices5);
        System.out.println("Test case 5: Maximum profit: " + profit5); // prints "Maximum profit: 2"


        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        rotate(nums1, k1);
        System.out.println("Test case 1: Rotated array: " + Arrays.toString(nums1));  // prints "Rotated array: [5, 6, 7, 1, 2, 3, 4]"

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        rotate(nums2, k2);
        System.out.println("Test case 2: Rotated array: " + Arrays.toString(nums2));  // prints "Rotated array: [3, 99, -1, -100]"

        int[] nums3 = {1, 2};
        int k3 = 3;
        rotate(nums3, k3);
        System.out.println("Test case 3: Rotated array: " + Arrays.toString(nums3));  // prints "Rotated array: [2, 1]"

        int[] nums4 = {1};
        int k4 = 0;
        rotate(nums4, k4);
        System.out.println("Test case 4: Rotated array: " + Arrays.toString(nums4));  // prints "Rotated array: [1]"

        int[] nums5 = {1, 2, 3, 4, 5, 6};
        int k5 = 6;
        rotate(nums5, k5);
        System.out.println("Test case 5: Rotated array: " + Arrays.toString(nums5));  // prints "Rotated array: [1, 2, 3, 4, 5, 6]"



        int[] inputCase1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int results1 = maxSubarray(inputCase1);
        System.out.println("Example 1: Input: " + Arrays.toString(inputCase1) + "\nResult: " + results1);

        // Example 2: Case with a negative number in the middle
        int[] inputCase2 = {1, 2, 3, -4, 5, 6};
        int results2 = maxSubarray(inputCase2);
        System.out.println("Example 2: Input: " + Arrays.toString(inputCase2) + "\nResult: " + results2);

        // Example 3: Case with all negative numbers
        int[] inputCase3 = {-1, -2, -3, -4, -5};
        int results3 = maxSubarray(inputCase3);
        System.out.println("Example 3: Input: " + Arrays.toString(inputCase3) + "\nResult: " + results3);

        // Example 4: Case with all positive numbers
        int[] inputCase4 = {1, 2, 3, 4, 5};
        int results4 = maxSubarray(inputCase4);
        System.out.println("Example 4: Input: " + Arrays.toString(inputCase4) + "\nResult: " + results4);

        // Example 5: Case with alternating positive and negative numbers
        int[] inputCase5 = {1, -1, 1, -1, 1};
        int results5 = maxSubarray(inputCase5);
        System.out.println("Example 5: Input: " + Arrays.toString(inputCase5) + "\nResult: " + results5);

    }

    public static int maxSubarray(int[] inputCase) {
        if  (inputCase.length == 0) { return 0; }
        int maxSum=inputCase[0];
        int sum;
        int subSum;

        for(int i=0; i<inputCase.length; i++) {
            sum=inputCase[i];
            subSum=Integer.MIN_VALUE;
            for (int j = i + 1; j < inputCase.length; j++) {
                sum += inputCase[j];
                if (sum > subSum ) {
                    subSum = sum;
                }
            }

            if (subSum > maxSum) {
                maxSum = subSum;
            }
        }
        return maxSum;
    }

    public static void rotate(int[] nums, int k) {
        if (k == nums.length || k == 0 || k < 0) return;
        if (k > nums.length) {
            swapElement(nums, 0, nums.length - 1);
            return;
        }
        int i, j;
        for (i = 0, j = nums.length - k - 1; i < (nums.length / 2) - 1; i++, j--) {
            swapElement(nums, i, j);
        }
        for (i = nums.length - k, j = nums.length - 1; i < nums.length - 1; i++, j--) {
            swapElement(nums, i, j);
        }
        for (i = 0, j = nums.length - 1; i < nums.length / 2; i++, j--) {
            swapElement(nums, i, j);
        }
    }

    public static int maxProfit(int[] prices) {
        int maxProfit=0;
        for (int i = 0; i < prices.length-1; i++) {
            int j=i+1;
            while (j < prices.length) {
                if (prices[j] > prices[i] && prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
                j++;
            }
        }
        return maxProfit;
    }

    public static int removeDuplicates(int[] array) {
        if (array == null || array.length == 0) return 0;
        int i = 0;
        for (int j = i + 1; j < array.length; j++) {
            if (array[i] < array[j]) {
                swapElement(array, i + 1, j);
                i++;
            }
        }
        return i+1;
    }

    public static String findLongestString(String[] strings) {
        if (strings == null || strings.length == 0) return "";
        int longestStringIndex = 0;
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() > strings[longestStringIndex].length()) {
                longestStringIndex = i;
            }
        }
        return strings[longestStringIndex];
    }

    public static int[] findMaxMin(int[] list) {
        int[] result = new int[2];
        result[0] = -100;
        result[1] = 100;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > result[0]) {
                result[0] = list[i];
            }
            if (list[i] < result[1]) {
                result[1] = list[i];
            }
        }
        return result;
    }

    private static int removeElement(int[] array, int val2) {
        int i=0;
        int j=0;
            while (j < array.length) {
                if (array[j] != val2) {
                    swapElement(array, i, j);
                    i++;
                }
                j++;
            }
        return i;
    }

    private static void swapElement(int[] array, int i, int j) {
        int temp= array[i];
        array[i]= array[j];
        array[j]=temp;
    }
}