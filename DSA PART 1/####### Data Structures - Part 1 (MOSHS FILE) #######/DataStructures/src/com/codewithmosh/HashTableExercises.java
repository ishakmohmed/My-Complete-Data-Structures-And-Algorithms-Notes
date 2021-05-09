package com.codewithmosh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableExercises {

    // O(n)
    public int[] twoSum(int[] numbers, int target) {
        // This problem is a variation of the previous problem
        // (countPairsWithDiff).
        //
        // If a + b = target, then b = target - a.
        //
        // So we iterate our array, and pick (a). Then,
        // we check to see if we have (b) in our array.
        // Similar to the last problem, this would be an O(n^2)
        // operation, because we'll need two nested loops for
        // looking up (b).
        //
        // We can optimize this by using a hash table. In this
        // hash table, we store numbers and their indexes.
        //
        // There is no need to store all the numbers in the hash table
        // first. If we find two numbers that add up to the target,
        // we simply return their indexes.

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(numbers[i], i);
        }

        // Time complexity of this method is O(n) because we need to iterate
        // the array only once.

        return null;
    }

    // O(n)
    public int mostFrequent(int[] numbers) {
        // To find the most frequent item in an array, we have to count the
        // number of times each item has been repeated. We can use a hash
        // table to store the items and their frequencies.
        Map<Integer, Integer> map = new HashMap<>();
        for (var number : numbers) {
            var count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }

        // Once we've populated our hash table, we need to iterate over all
        // key/value pairs and find the one with the highest frequency.
        int max = -1;
        int result = numbers[0];
        for (var item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                result = item.getKey();
            }
        }

        // Runtime complexity of this method is O(n) because we have to
        // iterate the entire array to populate our hash table.

        return result;
    }



}
