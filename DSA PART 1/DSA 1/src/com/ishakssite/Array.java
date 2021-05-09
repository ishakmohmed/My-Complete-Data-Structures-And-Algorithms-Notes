package com.ishakssite;

import java.util.ArrayList;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        if (items.length == count) {
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++) newItems[i] = items[i];

            items = newItems;
        }
        items[count++] = item; // setting value at items[count] (the last value, not necessarily last possible value in array) and then incrementing count cause there is another element now!
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i + 1];

        count--;
    }

    public int indexOf(int item) { // Runtime complexity: O(n);
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;

        return -1;
    }

    public int max() {
        int max = items[0];
        for (int i = 0; i < count; i++)
            if (items[i] > max)
                max = items[i];

        return max;
    }

    public Integer[] intersect(int[] anotherArray) { // My own solution for Mosh's exercise, probably not optimized!
        ArrayList<Integer> temporary = new ArrayList<>();

        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < anotherArray.length; j++) {
                if (items[i] == anotherArray[j])
                    temporary.add(items[i]);
            }
        }

        Integer[] array = temporary.toArray(new Integer[0]); // idk why I wrote new Integer[0], I googled a little and found out it has got something to do with Collections, Mosh will probably teach this in Mosh Java 3!
        return array;
    }

    public int[] reverse() {
        int[] temporaryArray = new int[count];

        int counter = 0;

        for (int i = count - 1; i >= 0; i--) {
            temporaryArray[i] = items[counter];
            counter++;
        }

        return temporaryArray;
    }

    public void insertAt(int item, int index) {
        // In future, don't worry about this function, it works perfect!
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        if (items.length == count) {
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++)
                newItems[i] = items[i];

            items = newItems;
        }

        for (int i = index; i < count; i++)
            items[i + 1] = items[i];

        items[index] = item;

        count++;
    }

    public void print() {   // works good, but it prints as [200, 300, 400, 500, ] <<< see the extra comma? not a prob to me cause mosh only printed each element in each line in his implementation! Plus you can easily fix that, the solution is too simple!
        System.out.print("[");
        for (int i = 0; i < count; i++)
            System.out.print(items[i] + ", ");

        System.out.println("]");
    }
}
