package org.leetcode.learning.Sorts;


import org.leetcode.learning.LinkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(6);
        myLinkedList.append(4);
        myLinkedList.append(5);


        System.out.println("Unsorted Linked List:");
        myLinkedList.printList();

//        myLinkedList.bubbleSort();
//        myLinkedList.selectionSort();
        myLinkedList.insertionSort();
        LinkedList second = new LinkedList(3);
        second.append(1);
        second.append(2);

        second.insertionSort();
        myLinkedList.merge(second);
        System.out.println("\nSorted Linked List:");
        myLinkedList.printList();


        /*
            EXPECTED OUTPUT:
            ----------------
            Unsorted Linked List:
            4
            2
            6
            5
            1
            3

            Sorted Linked List:
            1
            2
            3
            4
            5
            6

        */
    }
}