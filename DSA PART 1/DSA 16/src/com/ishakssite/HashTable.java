package com.ishakssite;
import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {
        var index = hash(key);

        if (entries[index] == null) entries[index] = new LinkedList<>();

        for (var entry : entries[index]) { // when someone passes a duplicate key!
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        entries[index].addLast(new Entry(key, value)); // otherwise just add entry at the end of linked list!
    }

    public String get(int key) {
        var index = hash(key);

        if (entries[index] != null) {
            for (var entry : entries[index])
                if (entry.key == key)
                    return entry.value;
        }
        return null;
    }

    public void remove(int key) {
        var index = hash(key);

        if (entries[index] == null)
            throw new IllegalStateException();

        for (var entry : entries[index]) {
            if (entry.key == key) {
                entries[index].remove(entry); // REMOVE THE ENTIRE ENTRY IN LINKED LIST
                return;
            }
        }

        throw new IllegalStateException();
    }

    private int hash(int key) {
        // in real world, you might wanna use Math.abs() to get absolute value of key in case it is negative!
        return key % entries.length;
    }
}
