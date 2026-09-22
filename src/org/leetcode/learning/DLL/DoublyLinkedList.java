package org.leetcode.learning.DLL;

import org.leetcode.learning.LinkedList.LinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void reverseBetween(int startIndex , int endIndex ) {
        if (head==null || head.next==null || startIndex==endIndex) return;
        Node dummy= new Node(0);
        dummy.next=head;
        Node prev=dummy;
        for (int i = 0; i <startIndex; i++) {
            prev=prev.next;
        }
        Node current=prev.next;
        for (int i = 1; i < endIndex-startIndex; i++) {
            Node toMove=current.next;
            current.next=toMove.next;
            toMove.next.prev=current;
            toMove.next=current;
            toMove.prev=prev;
            current.prev=toMove;
            prev.next=toMove;
//            prev=prev.next;
        }
        head=dummy.next;
        head.prev=null;
    }

    class Node {
        int value;
        Node prev;
        Node next;

        Node(int value)
        {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public Node getHead() {
        return head;
    }

    public DoublyLinkedList() {
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " , ");
            temp = temp.next;
        }
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp;
        if (index <= length / 2) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
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

    public boolean insert(int index, int value) {
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
        Node before = get(index-1);
        Node after = before.next;
        before.next= newNode;
        after.prev= newNode;
        newNode.prev= before;
        newNode.next= after;
        length++;
        return true;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        if (length == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        length--;
        return temp;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = tail;
        if (length == 1) {
            temp.prev = null;
            temp.next = null;
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == length - 1) return removeLast();
        if (index == 0) return removeFirst();
        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }
    public boolean palindrome() {
        if (length == 1 || length==0) return true;
        Node first = head;
        Node last = tail;
        while (first!=last) {
            if (first.value != last.value) return false;
            first = first.next;
            last = last.prev;
        }
        return true;
    }

    public void reverse() {
        if (length == 1 || length==0) return ;
        Node current = head;
        Node temp = null;
        while (current.next != null) {
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
            temp= current.prev;
        }
        current.prev = current.next;
        current.next = temp;
        tail= head;
        head= current;
    }
    public void makeEmpty() {
        head = null;
        tail= null;
        length = 0;
    }
    public void partitionList (int value) {
        if (head==null || head.next==null) return;
        Node temp = head;
        Node dummy1 = new Node(0);
        Node prev1 = dummy1;
        Node dummy2 = new Node(0);
        Node prev2 = dummy2;
        while (temp != null) {
            if (value > temp.value) {
                prev1.next = temp;
                temp.prev = prev1;
                temp = temp.next;
                prev1=prev1.next;
                prev1.next=null;
            } else {
                prev2.next = temp;
                temp.prev = prev2;
                temp = temp.next;
                prev2=prev2.next;
                prev2.next=null;
            }
        }
        if (dummy1.next!=null) {
            head = dummy1.next;
            if (dummy2.next!= null) {
                prev1.next =dummy2.next;
                dummy2.next.prev = prev1;
            }
        }else {
            if (dummy2.next!=null)
                head = dummy2.next;
        }
        head.prev=null;
    }

    public void sort(int value){
        if (length == 0) return ;
        Node before = head;
        Node after= head.next;
        int index = 0;
        for (int i=0;i<length;i++){
            for (int j=i+1;j<length;j++){
                if (value > before.value){

                }
               after= after.next;
            }
            before=before.next;
        }
    }

    public void swap(int index1, int index2) {
        int first = get(index1).value;
        int second = get(index2).value;
        set(index1, second);
        set(index2, first);
    }
}