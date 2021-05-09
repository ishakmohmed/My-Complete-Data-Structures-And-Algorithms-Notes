package com.ishakssite;

public class MaxHeap {
    public static void heapify(int[] array) {
        // NOTE: INDEX OF LAST PARENT IS : (NUMBER OF NODES / 2) - 1;

        var lastParentIndex = array.length / 2 - 1;

        // remember 1- instead of traversing from starting node, im doing it
        // the opposite way so we'll have less recursion.
        // remember 2- array.length/2 is index of last parent so start from there,
        // cause you don't needa traverse the last nodes cause the parent node will
        // take care or something like that!
        for (var i = lastParentIndex; i >= 0; i--)
            heapify(array, i);
    }

    private static void heapify(int[] array, int index) {
        var largerIndex = index; // initially we assume the root is the largest

        var leftIndex = index * 2 + 1;
        if (leftIndex < array.length && array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;

        var rightIndex = index * 2 + 2;
        if (rightIndex < array.length && array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        if (index == largerIndex) return;

        swap(array, index, largerIndex); // largerIndex is the left or right child
        heapify(array, largerIndex);
    }

    private static void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k ) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();

        var heap = new Heap();
        for (var number : array)
            heap.insert(number);

        for (var i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }
}
