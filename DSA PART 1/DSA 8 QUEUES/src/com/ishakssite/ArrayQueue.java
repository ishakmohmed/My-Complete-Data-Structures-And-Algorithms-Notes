package com.ishakssite;
import java.util.Arrays;

// [1, 2, 3, 4, 5]
// F            R , where F=front, R=rear, cause this is a queue!

// basically, to implement this, you just use simple logic, but just remember the line to implement circular...
// ...arrays, which is >>> rear = (rear + 1) % items.length; Same goes for front, but swap rear with front var!

public class ArrayQueue {
    private int[] items;
    private int rear;
    private int front;
    private int count;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    // "count" variable plays a huge role in determining whether the new item will get accepted!

    public void enqueue(int item) {
        if (count == items.length)
            throw new IllegalStateException();

        items[rear] = item; // add to the very left of array which is front and then move the pointer to the right, (but now we're using circular arrays)!
        // actually after above line, we need to rear++, but since we're using circular arrays, do this >>>
        rear = (rear + 1) % items.length; // circular array!
        count++;
    }

    public int dequeue() {
        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length; // circular array!
        count--;
        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
