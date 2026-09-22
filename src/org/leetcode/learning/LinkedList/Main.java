package org.leetcode.learning.LinkedList;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        System.out.println("1 -> 2 -> 3 -> 4 -> 5");
        System.out.println( "Middle Node: "+ myLinkedList.findMiddleNode().value);


        myLinkedList.append(6);


        System.out.println("===========================");
        System.out.println("1 -> 2 -> 3 -> 4 -> 5 -> 6");
        System.out.println( "Middle Node: "+ myLinkedList.findMiddleNode().value);

        System.out.println("LL before remove():");
        myLinkedList.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(2).value);
            System.out.println("LL after remove() in middle:");
        myLinkedList.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(0).value);
        System.out.println("LL after remove() of first node:");
        myLinkedList.printList();

        System.out.println("\nRemoved node:");
        System.out.println(myLinkedList.remove(2).value);
        System.out.println("LL after remove() of last node:");
        myLinkedList.printList();

        System.out.println("Unsorted Linked List:");
        myLinkedList.printList();

        myLinkedList.bubbleSort();

        System.out.println("\nSorted Linked List:");
        myLinkedList.printList();

        LinkedList myLinkedList2 = new LinkedList(1);
        myLinkedList2.append(2);
        myLinkedList2.append(3);
        myLinkedList2.append(4);
        myLinkedList2.append(5);

        int k = 2;
        int result = myLinkedList2.findKthFromEnd(k).value;

        System.out.println("findKthFromEnd: " +result); // Output: 4

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        myLinkedList = new LinkedList(1);
        myLinkedList.makeEmpty();
        myLinkedList.removeDuplicates();
        System.out.println("Expected: List is empty");
        myLinkedList.printList();
        System.out.println();

        // Test 2: Single node (no duplicates)
        System.out.println("Test 2: Single Node");
        myLinkedList = new LinkedList(10);
        myLinkedList.removeDuplicates();
        System.out.println("Expected: 10");
        myLinkedList.printList();
        System.out.println();

        // Test 3: Multi-node (no duplicates)
        System.out.println("Test 3: No Duplicates");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.removeDuplicates();
        System.out.println("Expected: 1 -> 2 -> 3");
        myLinkedList.printList();
        System.out.println();

        // Test 4: Duplicates in the middle
        System.out.println("Test 4: Duplicates in Middle");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.removeDuplicates();
        System.out.println("Expected: 1 -> 2 -> 3");
        myLinkedList.printList();
        System.out.println();

        // Test 5: All elements are duplicates
        System.out.println("Test 5: All Duplicates");
        myLinkedList = new LinkedList(5);
        myLinkedList.append(5);
        myLinkedList.append(5);
        myLinkedList.append(5);
        myLinkedList.removeDuplicates();
        System.out.println("Expected: 5");
        myLinkedList.printList();
        System.out.println();

        // Test 6: Duplicates at start and end
        System.out.println("Test 6: Duplicates at Start/End");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(3);
        myLinkedList.removeDuplicates();
        System.out.println("Expected: 1 -> 2 -> 3");
        myLinkedList.printList();
        System.out.println();

        // Test 7: Mixed duplicates throughout
        System.out.println("Test 7: Mixed Duplicates");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(1);
        myLinkedList.append(3);
        myLinkedList.append(2);
        myLinkedList.append(4);
        myLinkedList.removeDuplicates();
        System.out.println("Expected: 1 -> 2 -> 3 -> 4");
        myLinkedList.printList();
        System.out.println();



        myLinkedList.makeEmpty();
        System.out.println("List: (empty)");
        System.out.println("Expected: 0");
        System.out.println("Actual: " + myLinkedList.binaryToDecimal());
        System.out.println();

        // Test 2: Single node (0)
        System.out.println("Test 2: Single Node (0)");
        myLinkedList = new LinkedList(0);
        System.out.print("List: ");
        myLinkedList.printList();
        System.out.println("Expected: 0");
        System.out.println("Actual: " + myLinkedList.binaryToDecimal());
        System.out.println();

        // Test 3: Single node (1)
        System.out.println("Test 3: Single Node (1)");
        myLinkedList = new LinkedList(1);
        System.out.print("List: ");
        myLinkedList.printList();
        System.out.println("Expected: 1");
        System.out.println("Actual: " + myLinkedList.binaryToDecimal());
        System.out.println();

        // Test 4: Multi-node (101)
        System.out.println("Test 4: Multi-Node (101)");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(0);
        myLinkedList.append(1);
        System.out.print("List: ");
        myLinkedList.printList();
        System.out.println("Expected: 5");
        System.out.println("Actual: " + myLinkedList.binaryToDecimal());
        System.out.println();

        // Test 5: Multi-node (1111)
        System.out.println("Test 5: Multi-Node (1111)");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(1);
        myLinkedList.append(1);
        myLinkedList.append(1);
        System.out.print("List: ");
        myLinkedList.printList();
        System.out.println("Expected: 15");
        System.out.println("Actual: " + myLinkedList.binaryToDecimal());
        System.out.println();

        // Test 6: Multi-node (10010)
        System.out.println("Test 6: Multi-Node (10010)");
        myLinkedList = new LinkedList(1);
        myLinkedList.append(0);
        myLinkedList.append(0);
        myLinkedList.append(1);
        myLinkedList.append(0);
        System.out.print("List: ");
        myLinkedList.printList();
        System.out.println("Expected: 18");
        System.out.println("Actual: " + myLinkedList.binaryToDecimal());
        System.out.println();



        LinkedList linkedList;

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        linkedList = new LinkedList(1);
        linkedList.makeEmpty();
        linkedList.partitionList(3);
        System.out.println("List: (empty)");
        System.out.println("Expected: empty");
        linkedList.printList();
        System.out.println();

        // Test 2: Single node (< x)
        System.out.println("Test 2: Single Node (< x)");
        linkedList = new LinkedList(1);
        linkedList.partitionList(3);
        System.out.println("List: 1");
        System.out.println("Expected: 1");
        linkedList.printList();
        System.out.println();

        // Test 3: Single node (>= x)
        System.out.println("Test 3: Single Node (>= x)");
        linkedList = new LinkedList(5);
        linkedList.partitionList(3);
        System.out.println("List: 5");
        System.out.println("Expected: 5");
        linkedList.printList();
        System.out.println();

        // Test 4: All nodes < x
        System.out.println("Test 4: All Nodes < x");
        linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(0);
        linkedList.partitionList(5);
        System.out.println("List: 1 -> 2 -> 0");
        System.out.println("Expected: 1 -> 2 -> 0");
        linkedList.printList();
        System.out.println();

        // Test 5: All nodes >= x
        System.out.println("Test 5: All Nodes >= x");
        linkedList = new LinkedList(5);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.partitionList(5);
        System.out.println("List: 5 -> 6 -> 7");
        System.out.println("Expected: 5 -> 6 -> 7");
        linkedList.printList();
        System.out.println();

        // Test 6: Mixed nodes (< x and >= x)
        System.out.println("Test 6: Mixed Nodes");
        linkedList = new LinkedList(3);
        linkedList.append(5);
        linkedList.append(8);
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(2);
        linkedList.append(1);
        linkedList.partitionList(5);
        System.out.println("Original List: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1");
        System.out.println("Expected: 3 -> 2 -> 1 -> 5 -> 8 -> 5 -> 10");
        linkedList.printList();
        System.out.println();

        // Test 7: Nodes with duplicates around pivot
        System.out.println("Test 7: Duplicates Around Pivot");
        linkedList = new LinkedList(5);
        linkedList.append(1);
        linkedList.append(5);
        linkedList.append(0);
        linkedList.append(5);
        linkedList.partitionList(5);
        System.out.println("Original List: 5 -> 1 -> 5 -> 0 -> 5");
        System.out.println("Expected: 1 -> 0 -> 5 -> 5 -> 5");
        linkedList.printList();
        System.out.println();


        LinkedList linkedListToReverse;

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        linkedListToReverse = new LinkedList(1);
        linkedListToReverse.makeEmpty();
        linkedListToReverse.reverseBetween(0, 0);
        System.out.println("List: (empty)");
        System.out.println("Expected: empty");
        linkedListToReverse.printList();
        System.out.println();

        // Test 2: Single node list
        System.out.println("Test 2: Single Node");
        linkedListToReverse = new LinkedList(10);
        linkedListToReverse.reverseBetween(0, 0);
        System.out.println("List: 10");
        System.out.println("Expected: 10");
        linkedListToReverse.printList();
        System.out.println();

        // Test 3: Reverse sublist in middle (1 -> 2 -> 3 -> 4 -> 5; reverse 1..3)
        System.out.println("Test 3: Reverse Sublist in Middle");
        linkedListToReverse = new LinkedList(1);
        for (int i = 2; i <= 5; i++) linkedListToReverse.append(i);
        linkedListToReverse.reverseBetween(1, 3);  // Reverse nodes 2,3,4
        System.out.println("Original: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Expected: 1 -> 4 -> 3 -> 2 -> 5");
        linkedListToReverse.printList();
        System.out.println();

        // Test 4: Reverse from head (reverse 0..2)
        System.out.println("Test 4: Reverse From Head");
        linkedListToReverse = new LinkedList(1);
        for (int i = 2; i <= 5; i++) linkedListToReverse.append(i);
        linkedListToReverse.reverseBetween(0, 2);  // Reverse nodes 1,2,3
        System.out.println("Original: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Expected: 3 -> 2 -> 1 -> 4 -> 5");
        linkedListToReverse.printList();
        System.out.println();

        // Test 5: Reverse to tail (reverse 2..4)
        System.out.println("Test 5: Reverse To Tail");
        linkedListToReverse = new LinkedList(1);
        for (int i = 2; i <= 5; i++) linkedListToReverse.append(i);
        linkedListToReverse.reverseBetween(2, 4);  // Reverse nodes 3,4,5
        System.out.println("Original: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Expected: 1 -> 2 -> 5 -> 4 -> 3");
        linkedListToReverse.printList();
        System.out.println();

        // Test 6: Reverse entire list (0..4)
        System.out.println("Test 6: Reverse Entire List");
        linkedListToReverse = new LinkedList(1);
        for (int i = 2; i <= 5; i++) linkedListToReverse.append(i);
        linkedListToReverse.reverseBetween(0, 4);
        System.out.println("Original: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Expected: 5 -> 4 -> 3 -> 2 -> 1");
        linkedListToReverse.printList();
        System.out.println();

        // Test 7: startIndex == endIndex (no change)
        System.out.println("Test 7: No Change (start == end)");
        linkedListToReverse = new LinkedList(1);
        for (int i = 2; i <= 5; i++) linkedListToReverse.append(i);
        linkedListToReverse.reverseBetween(2, 2);
        System.out.println("Original: 1 -> 2 -> 3 -> 4 -> 5");
        System.out.println("Expected: 1 -> 2 -> 3 -> 4 -> 5");
        linkedListToReverse.printList();
        System.out.println();



        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        LinkedList linkedListToSwap = new LinkedList(1);
        linkedListToSwap.makeEmpty();
        linkedListToSwap.swapPairs();
        System.out.println("Expected: empty");
        linkedListToSwap.printList();
        System.out.println();

        // Test 2: Single node (no swap)
        System.out.println("Test 2: Single Node");
        linkedListToSwap = new LinkedList(10);
        linkedListToSwap.swapPairs();
        System.out.println("Expected: 10");
        linkedListToSwap.printList();
        System.out.println();

        // Test 3: Two nodes (swap them)
        System.out.println("Test 3: Two Nodes");
        linkedListToSwap = new LinkedList(1);
        linkedListToSwap.append(2);
        linkedListToSwap.swapPairs();
        System.out.println("Expected: 2 -> 1");
        linkedListToSwap.printList();
        System.out.println();

        // Test 4: Odd number of nodes (3 nodes)
        System.out.println("Test 4: Odd Length List");
        linkedListToSwap = new LinkedList(1);
        linkedListToSwap.append(2);
        linkedListToSwap.append(3);
        linkedListToSwap.swapPairs();
        System.out.println("Expected: 2 -> 1 -> 3");
        linkedListToSwap.printList();
        System.out.println();

        // Test 5: Even number of nodes (4 nodes)
        System.out.println("Test 5: Even Length List");
        linkedListToSwap = new LinkedList(1);
        linkedListToSwap.append(2);
        linkedListToSwap.append(3);
        linkedListToSwap.append(4);
        linkedListToSwap.swapPairs();
        System.out.println("Expected: 2 -> 1 -> 4 -> 3");
        linkedListToSwap.printList();
        System.out.println();

        // Test 6: Longer list (6 nodes)
        System.out.println("Test 6: Longer List (6 Nodes)");
        linkedListToSwap = new LinkedList(1);
        for (int i = 2; i <= 6; i++) linkedListToSwap.append(i);
        linkedListToSwap.swapPairs();
        System.out.println("Expected: 2 -> 1 -> 4 -> 3 -> 6 -> 5");
        linkedListToSwap.printList();
        System.out.println();


    }
}