package com.ishakssite;
import java.util.Arrays;

public class PriorityQueue {
    private int[] items = new int[5];
    private int count;

    public void add(int item) {
        if (isFull())
            throw new IllegalStateException();

        var i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public int shiftItemsToInsert(int item) {
        int i; // need to declare here!

        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else
                break;
        }
        return i + 1; // because add() uses i variable! Also, I'm adding 1 here cause when you insert element in add() above, you will insert in i + 1, assuming i is super small value and the item you wanna insert should be to the exact right of i, so i + 1!
    }

    public int remove() { // but this time the largest number which is on the right of the array will be removed first which is easy count we've got the count variable, but, in actual priority queues, the smallest element will be removed first!
        if (isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
