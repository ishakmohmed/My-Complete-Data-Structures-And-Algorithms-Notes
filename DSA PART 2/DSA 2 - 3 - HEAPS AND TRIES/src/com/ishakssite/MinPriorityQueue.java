package com.ishakssite;

public class MinPriorityQueue {
    private MinHeap heap = new MinHeap();

    public void add(String value, int priority) { // I guess priority is key
        heap.insert(priority, value);
    }

    public String remove() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
