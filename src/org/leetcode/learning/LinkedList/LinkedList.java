package org.leetcode.learning.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public void removeDuplicates() {
        Set<Integer> set = new HashSet<Integer>();
        if  (head == null) return;
        Node prev=null;
        Node current=head;
        while (current!=null){
            if (set.contains(current.value))
                prev.next = current.next;
            else {
                prev=current;
                set.add(current.value);
            }
            current=current.next;
        }
    }

    public int binaryToDecimal() {
        if (head == null) return 0;
        int sum = 0;
        Node current = head;
        while (current!=null){
            sum*=2;
            if (current.value==1)
                sum+=1;
            current=current.next;
        }
        return sum;
    }

    public void partitionList(int i) {
        if (head == null) return;
        Node dummy1=new Node(0);
        Node prev1=dummy1;
        Node dummy2=new Node(0);
        Node prev2=dummy2;
        Node current=head;
        while(current!=null){
            if(current.value<i){
                prev1.next=new Node(current.value);
                prev1=prev1.next;
                current=current.next;
            } else {
                prev2.next=new Node(current.value);
                prev2=prev2.next;
                current=current.next;
            }
        }
        prev1.next=dummy2.next;
        head=dummy1.next;
    }

    public void reverseBetween(int startIndex , int endIndex ) {
        if (head == null || length == 1 || startIndex==endIndex) return;
        Node dummy= new Node(0);
        dummy.next=head;
        Node prev=dummy;
        for (int i = 0; i < startIndex; i++) {
            prev=prev.next;
        }
        Node current=prev.next;
        for (int i = 0; i < endIndex-startIndex; i++) {
            Node toMove=current.next;
            current.next=toMove.next;
            toMove.next=prev.next;
            prev.next=toMove;
        }
        head=dummy.next;
    }

    public void swapPairs() {
        if (head == null || head.next == null) return;
        Node dummy=new Node(0);
        dummy.next=head;
        Node prev=dummy;
        Node first=prev.next;
        Node second;
        while (first!=null && first.next!=null) {
            second=first.next;
            first.next=second.next;
            second.next=first;
            prev.next=second;
            prev=first;
            first=first.next;
        }
        head=dummy.next;
    }


    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value)  {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node remove(int index) {
        if (head == null|| index>length-1) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();
        Node temp = get(index-1);
        Node removed = temp.next;
        temp.next = temp.next.next;

        length--;
        return removed;
    }

    public Node findMiddleNode(){
        if (head == null || head.next ==null) {
            return head;
        }
        Node temp = head;
        int length=0;
        while (temp.next != tail) {
            temp = temp.next;
            length++;
        };
        temp=head;
        for (int i=0;i<length/2;i++) {
            temp=temp.next;
        }
        return temp.next;
    }

    public Node findKthFromEnd(int index) {
        if (index < 0 || head == null || index == 0) return null;
        if (index == 1) return tail;

        Node fast = head;
        Node slow = head;
        for (int i=0; i<index; i++) {
            fast = fast.next;
            if (fast == null) return null;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public Node removeLast() {
        if (head == null) return null;
        if (head == tail) {
            Node temp = new Node(head.value);
            head = null;
            tail = null;
            length--;
            return temp;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            Node result = new Node(temp.next.value);
            tail=temp;
            tail.next = null;
            length--;
            temp=result;
            return temp;
        }
    }

    public void bubbleSort() {
        if(head == null) return;
        Node sortedUntil = null;
        while (sortedUntil!=this.head.next) {
            Node temp = head;
            while (temp.next != sortedUntil) {
                if (temp.value > temp.next.value) {
                    int swap = temp.value;
                    temp.value = temp.next.value;
                    temp.next.value = swap;
                }
                temp = temp.next;
            }
            sortedUntil = temp;
        }
    }

    public void selectionSort() {
        if(head == null) return;
        Node current = head;
        while (current.next != null) {
            Node smallest = current;
            Node innerCurrent = current.next;
            while (innerCurrent !=null) {
                if (innerCurrent.value < smallest.value) {
                    int swap = innerCurrent.value;
                    innerCurrent.value = smallest.value;
                    smallest.value = swap;
                }
                innerCurrent = innerCurrent.next;
            }
            if(smallest != current) {
                int swap = current.value;
                current.value = smallest.value;
                smallest.value = swap;
            }
            current= current.next;
        }
    }

    public void insertionSort() {
        if(head == null) return;
        Node sortedListHead  = head;
        Node unsortedListHead  = sortedListHead.next;
        while (unsortedListHead!=null) {
            Node searchPointer = unsortedListHead;
            while (searchPointer!=null) {
                if (searchPointer.value < sortedListHead.value) {
                    int swap = searchPointer.value;
                    searchPointer.value = sortedListHead.value;
                    sortedListHead.value = swap;
                }
                searchPointer = searchPointer.next;
            }
            sortedListHead = sortedListHead.next;
            unsortedListHead=unsortedListHead.next;
        }
    }

    public void merge(LinkedList otherList) {
        Node otherHead = otherList.head;
        Node origianl = head;
        LinkedList merged = new LinkedList(0);
        while (otherHead != null && origianl != null) {
            if (origianl.value < otherHead.value) {
                merged.append(origianl.value);
                origianl = origianl.next;
            } else {
                merged.append(otherHead.value);
                otherHead = otherHead.next;
            }
        }
    }

    public void mergeSort(LinkedList otherList) {
        Node otherHead = otherList.head;
        Node dummy = new Node(0);
        dummy.next = head;
        Node current = dummy;
        while (otherHead != null && current.next != null) {
            if (otherHead.value < current.next.value) {
                Node cut = current.next;
                current.next = new Node(otherHead.value);
                current.next.next = cut;
                otherHead = otherHead.next;
                current=current.next;
            }
            else {
                current=current.next;
            }
        }
        if (otherHead != null) {
            while(otherHead != null) {
                current.next= new Node(otherHead.value);
                otherHead=otherHead.next;
            }
        }
    }
}
