package org.leetcode.learning.DLL;

import java.util.*;

public class Main {

    private static void printForward(DoublyLinkedList dll) {
        DoublyLinkedList.Node current = dll.getHead();
        if (current == null) {
            System.out.println("Forward: empty");
            return;
        }
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) System.out.print(" <-> ");
            current = current.next;
        }
        System.out.println();
    }

    private static void printBackward(DoublyLinkedList dll) {
        DoublyLinkedList.Node current = dll.getHead();
        if (current == null) {
            System.out.println("Backward: empty");
            return;
        }
        while (current.next != null) current = current.next;  // move to tail
        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.value);
            if (current.prev != null) System.out.print(" <-> ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll;

        // Explain why we do forward and backward prints
        System.out.println("We print each list forward and backward");
        System.out.println("to confirm BOTH next and prev pointers");
        System.out.println("are correct after reverseBetween.");
        System.out.println();

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        dll = new DoublyLinkedList(1);
        dll.makeEmpty();
        dll.partitionList(3);
        System.out.println("Expected Forward: empty");
        System.out.println("Expected Backward: empty");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 2: Single node (< x)
        System.out.println("Test 2: Single Node (< x)");
        dll = new DoublyLinkedList(1);
        dll.partitionList(5);
        System.out.println("Expected Forward: 1");
        System.out.println("Expected Backward: 1");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 3: Single node (>= x)
        System.out.println("Test 3: Single Node (>= x)");
        dll = new DoublyLinkedList(9);
        dll.partitionList(5);
        System.out.println("Expected Forward: 9");
        System.out.println("Expected Backward: 9");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 4: All nodes < x
        System.out.println("Test 4: All Nodes < x");
        dll = new DoublyLinkedList(1);
        dll.append(2);
        dll.append(3);
        dll.partitionList(5);
        System.out.println("Expected Forward: 1 <-> 2 <-> 3");
        System.out.println("Expected Backward: 3 <-> 2 <-> 1");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 5: All nodes >= x
        System.out.println("Test 5: All Nodes >= x");
        dll = new DoublyLinkedList(7);
        dll.append(8);
        dll.append(9);
        dll.partitionList(5);
        System.out.println("Expected Forward: 7 <-> 8 <-> 9");
        System.out.println("Expected Backward: 9 <-> 8 <-> 7");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 6: Mixed nodes
        System.out.println("Test 6: Mixed Nodes");
        dll = new DoublyLinkedList(3);
        dll.append(5);
        dll.append(8);
        dll.append(5);
        dll.append(10);
        dll.append(2);
        dll.append(1);
        dll.partitionList(5);
        System.out.println("Expected Forward: 3 <-> 2 <-> 1 <-> 5 <-> 8 <-> 5 <-> 10");
        System.out.println("Expected Backward: 10 <-> 5 <-> 8 <-> 5 <-> 1 <-> 2 <-> 3");
        printForward(dll);
        printBackward(dll);
        System.out.println();

        // Test 7: Duplicates around pivot
        System.out.println("Test 7: Duplicates Around Pivot");
        dll = new DoublyLinkedList(5);
        dll.append(1);
        dll.append(5);
        dll.append(0);
        dll.append(5);
        dll.partitionList(5);
        System.out.println("Expected Forward: 1 <-> 0 <-> 5 <-> 5 <-> 5");
        System.out.println("Expected Backward: 5 <-> 5 <-> 5 <-> 0 <-> 1");
        printForward(dll);
        printBackward(dll);
        System.out.println();


        DoublyLinkedList linkedListToReverse;

        // Explain why we do forward and backward prints
        System.out.println("We print each list forward and backward");
        System.out.println("to confirm BOTH next and prev pointers");
        System.out.println("are correct after reverseBetween.");
        System.out.println();

        // Test 1: Empty list
        System.out.println("Test 1: Empty List");
        linkedListToReverse = new DoublyLinkedList(1);
        linkedListToReverse.makeEmpty();
        linkedListToReverse.reverseBetween(0,0);
        System.out.println("Expected Forward: empty");
        System.out.println("Expected Backward: empty");
        printForward(linkedListToReverse);
        printBackward(linkedListToReverse);
        System.out.println();

        // Test 2: Single node
        System.out.println("Test 2: Single Node");
        linkedListToReverse = new DoublyLinkedList(10);
        linkedListToReverse.reverseBetween(0,0);
        System.out.println("Expected Forward: 10");
        System.out.println("Expected Backward: 10");
        printForward(linkedListToReverse);
        printBackward(linkedListToReverse);
        System.out.println();

        // Test 3: Reverse partial (middle)
        System.out.println("Test 3: Reverse Partial (Middle)");
        linkedListToReverse = new DoublyLinkedList(1);
        for (int i = 2; i <= 5; i++) linkedListToReverse.append(i);
        linkedListToReverse.reverseBetween(1,3);  // Reverse 2,3,4
        System.out.println("Expected Forward: 1 <-> 4 <-> 3 <-> 2 <-> 5");
        System.out.println("Expected Backward: 5 <-> 2 <-> 3 <-> 4 <-> 1");
        printForward(linkedListToReverse);
        printBackward(linkedListToReverse);
        System.out.println();

        // Test 4: Reverse from head
        System.out.println("Test 4: Reverse From Head");
        linkedListToReverse = new DoublyLinkedList(1);
        for (int i = 2; i <= 5; i++) linkedListToReverse.append(i);
        linkedListToReverse.reverseBetween(0,2);  // Reverse 1,2,3
        System.out.println("Expected Forward: 3 <-> 2 <-> 1 <-> 4 <-> 5");
        System.out.println("Expected Backward: 5 <-> 4 <-> 1 <-> 2 <-> 3");
        printForward(linkedListToReverse);
        printBackward(linkedListToReverse);
        System.out.println();

        // Test 5: Reverse to tail
        System.out.println("Test 5: Reverse To Tail");
        linkedListToReverse = new DoublyLinkedList(1);
        for (int i = 2; i <= 5; i++) linkedListToReverse.append(i);
        linkedListToReverse.reverseBetween(2,4);  // Reverse 3,4,5
        System.out.println("Expected Forward: 1 <-> 2 <-> 5 <-> 4 <-> 3");
        System.out.println("Expected Backward: 3 <-> 4 <-> 5 <-> 2 <-> 1");
        printForward(linkedListToReverse);
        printBackward(linkedListToReverse);
        System.out.println();

        // Test 6: Reverse entire list
        System.out.println("Test 6: Reverse Entire List");
        linkedListToReverse = new DoublyLinkedList(1);
        for (int i = 2; i <= 5; i++) linkedListToReverse.append(i);
        linkedListToReverse.reverseBetween(0,4);  // Reverse all
        System.out.println("Expected Forward: 5 <-> 4 <-> 3 <-> 2 <-> 1");
        System.out.println("Expected Backward: 1 <-> 2 <-> 3 <-> 4 <-> 5");
        printForward(linkedListToReverse);
        printBackward(linkedListToReverse);
        System.out.println();

        // Test 7: No change (start == end)
        System.out.println("Test 7: No Change (start == end)");
        linkedListToReverse = new DoublyLinkedList(1);
        for (int i = 2; i <= 5; i++) linkedListToReverse.append(i);
        linkedListToReverse.reverseBetween(3,3);  // No change
        System.out.println("Expected Forward: 1 <-> 2 <-> 3 <-> 4 <-> 5");
        System.out.println("Expected Backward: 5 <-> 4 <-> 3 <-> 2 <-> 1");
        printForward(linkedListToReverse);
        printBackward(linkedListToReverse);
        System.out.println();
    }

}