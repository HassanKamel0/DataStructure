package org.leetcode.learning.Stack;

import java.util.ArrayList;

public class Stack<T> {
//    private StackNode top;
//    private int height;
    private ArrayList<T> stackList = new ArrayList<>();

//    public Stack(int value) {
//        StackNode newNode = new StackNode(value);
//        this.top = newNode;
//        height = 1;
//    }

    public ArrayList<T> getStackList() {
        return stackList;
    }
    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(T value) {
        stackList.add(value);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return stackList.remove(stackList.size()-1);
    }


//    public void push(int value) {
//        StackNode newNode = new StackNode(value);
//        if (height == 0) {
//            top = newNode;
//        } else {
//            newNode.next = top;
//            top = newNode;
//        }
//        height++;
//    }

//    public StackNode pop() {
//        if (height == 0) return null;
//        StackNode temp = top;
//        top = top.next;
//        height--;
//        return temp;
//    }
}
