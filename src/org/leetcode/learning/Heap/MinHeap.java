package org.leetcode.learning.Heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;
        while (current > 0 && (heap.get(current) < heap.get(parent(current)))) {
            swap(current, parent(current));
            current = parent(current);
        }
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
        int minIndex = index;
        while(true) {
            int left = leftChild(index);
            int right = rightChild(index);

            if(left < heap.size() && heap.get(left) < heap.get(minIndex)) {
                minIndex = left;
            }
            if(right < heap.size() && heap.get(right) < heap.get(minIndex)) {
                minIndex = right;
            }
            if (minIndex != index) {
                swap(index, minIndex);
                index = minIndex;
            }
            else return;
        }
    }
}