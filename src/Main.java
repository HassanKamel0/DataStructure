import org.leetcode.learning.Stack.Stack;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray())
            stack.push(c);
        char[] reversed = new char[str.length()];
        for (int i = 0; i < str.toCharArray().length; i++)
            reversed[i] = stack.pop();

        String reversedString = new String(reversed);
        return reversedString;
    }

    public static boolean isBalancedParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (stack.isEmpty())
                return false;
            else if (c == ')') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        Integer temp = stack.pop();
        Stack<Integer> holder = new Stack();
        while (!holder.isEmpty() || temp != null) {
            if (temp != null) {
                if (holder.isEmpty() || temp >= holder.peek()) {
                    holder.push(temp);
                    temp = stack.pop();
                } else if (temp < holder.peek()) {
                    stack.push(holder.pop());
                }
            } else {
                stack.push(holder.pop());
            }
        }
    }

    public static List<Integer> findDuplicates(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > 1) set.add(i);
        }
        return set.stream().toList();
    }

    public static Character firstNonRepeatingChar(String str) {
        char[] arr = str.toCharArray();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static List<List<String>> groupAnagrams(String[] strings){
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        for(String str : strings) {
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String key = String.valueOf(sorted);
            if (!map.containsKey(key)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static int[] twoSum(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            if (map.containsKey(target-arr[i])){
                return new int[]{map.get(target-arr[i]), i};
            }
            map.put(arr[i],i);
        }
        return new int[]{};
    }

    public static int[] subarraySum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (map.containsKey(currentSum - target)) {
                int[] interval = new int[2];
                interval[0] = map.get(currentSum - target) + 1;
                interval[1] = i;
                return interval;
            } else
                map.put(currentSum, i);
        }
        return new int[0];
    }

    public static List<Integer> removeDuplicates(List<Integer> myList){
        Set<Integer> set = new HashSet<>(myList);
        return new ArrayList<>(set);
    }

    public static boolean hasUniqueChars(String string){
        char[] arr = string.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c : arr) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target){
        Set<Integer> set = Arrays.stream(arr1).boxed()
                .collect(Collectors.toSet());
        List<int[]> pairs = new ArrayList<>();
        for (int i:arr2){
            if (set.contains(target-i)){
                pairs.add(new int[]{target-i,i});
            }
        }
        return pairs;
    }


    public static int longestConsecutiveSequence(int[] arr) {
        if (arr.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int currentStreak;
        int longestStreak=0;
        for (int i : set) {
            currentStreak = 0;
            if (!set.contains(i-1)) {
                currentStreak=1;
            }
            if (set.contains(i + 1)) {
                int j = i + 1;
                while (set.contains(j)) {
                    currentStreak++;
                    j++;
                }
            }
            longestStreak = Math.max(currentStreak, longestStreak);
        }
        return longestStreak;
    }


    private static String formatPairs(List<int[]> pairs) {
        List<String> formatted = new ArrayList<>();
        for (int[] pair : pairs) {
            formatted.add(Arrays.toString(pair));
        }
        return formatted.toString();
    }
    private static String formatResult(List<Integer> list) {
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);  // for consistent print order
        return sorted.toString();
    }

    public static void main(String[] args) {
        System.out.println("These tests confirm longestConsecutiveSequence()");
        System.out.println("returns the correct length of the longest");
        System.out.println("sequence of consecutive numbers.");
        System.out.println();

        // Test 1: Typical case
        System.out.println("Test 1: Typical Sequence");
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Expected: 4 (sequence 1-4)");
        System.out.println("Actual: " + longestConsecutiveSequence(nums1));
        System.out.println();

        // Test 2: No consecutive numbers
        System.out.println("Test 2: No Consecutive Numbers");
        int[] nums2 = {10, 30, 50};
        System.out.println("Expected: 1 (each stands alone)");
        System.out.println("Actual: " + longestConsecutiveSequence(nums2));
        System.out.println();

        // Test 3: All numbers consecutive
        System.out.println("Test 3: All Numbers Consecutive");
        int[] nums3 = {5, 6, 7, 8, 9};
        System.out.println("Expected: 5 (sequence 5-9)");
        System.out.println("Actual: " + longestConsecutiveSequence(nums3));
        System.out.println();

        // Test 4: Includes negatives
        System.out.println("Test 4: Handles Negatives");
        int[] nums4 = {-1, -2, -3, 0, 1};
        System.out.println("Expected: 5 (sequence -3 to 1)");
        System.out.println("Actual: " + longestConsecutiveSequence(nums4));
        System.out.println();

        // Test 5: Empty array
        System.out.println("Test 5: Empty Array");
        int[] nums5 = {};
        System.out.println("Expected: 0");
        System.out.println("Actual: " + longestConsecutiveSequence(nums5));
        System.out.println();
    }
}