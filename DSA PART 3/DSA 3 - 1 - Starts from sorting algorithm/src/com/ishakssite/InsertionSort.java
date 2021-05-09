package com.ishakssite;

public class InsertionSort {
    public void sort(int[] array) {
        for (var i = 1; i < array.length; i++) {
            var current = array[i];
            var j = i - 1; // previous item
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current; // after all greater items are shifted to the right, then we can finally store the current item at the right place!
        }
    }
}
