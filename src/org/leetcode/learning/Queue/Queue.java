package org.leetcode.learning.Queue;


public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue(int value)
    {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode ;
        length = 1;
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

    public void enqueue(int value)
    {

        Node newNode = new Node(value);
        if (length == 0) first= last= newNode;
        else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        if (length == 0) return null;
        Node temp = first;
        if (length == 1) {
            first = last = null;
        }else {
            first = first.next;
        }
        temp.next = null;
        length--;
        return temp;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }
}
