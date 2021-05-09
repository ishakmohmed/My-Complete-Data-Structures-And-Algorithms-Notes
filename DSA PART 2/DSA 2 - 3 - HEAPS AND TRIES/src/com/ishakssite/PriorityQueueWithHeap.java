package com.ishakssite;

public class PriorityQueueWithHeap {
    // this class has faster insertion and slower deletion
    // compared to normal priority queue

    private Heap heap = new Heap();

    public void enqueue(int item) { // faster insertion
        heap.insert(item);
    }

    public int dequeue() { // slower deletion
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
