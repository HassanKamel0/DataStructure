package org.leetcode.learning.Heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return heap;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;
        while (current > 0 && (heap.get(current) > heap.get(parent(current)))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public List<Integer> printHeap() {
        return heap;
    }

    public Integer remove(){
        if (heap.isEmpty()) return null;
        if (heap.size() == 1) return heap.removeFirst();
        int top = heap.getFirst();
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);
        return  top;
    }

    private void sinkDown(int index) {
        int maxIndex = index;
        while(true) {
            int left = leftChild(index);
            int right = rightChild(index);

            if(left < heap.size() && heap.get(left) > heap.get(maxIndex)) {
                maxIndex = left;
            }
            if(right < heap.size() && heap.get(right) > heap.get(maxIndex)) {
               maxIndex = right;
            }
            if (maxIndex != index) {
                swap(index, maxIndex);
                index = maxIndex;
            }
            else return;
        }
    }
}