package com.ishakssite;

public class Main {
    public static void main(String[] args) {
	    // create a HashTable and implement these :
        // put(k, v)
        // get(k): v
        // remove(k)
        // k: int
        // v: string
        // Collisions: chaining method
        // LinkedList<Entry>[] , where Entry is a custom class
        // [LL, LL, LL, LL, LL]

        HashTable table = new HashTable();

        table.put(6, "A");
        table.put(8, "B");
        table.put(11, "C");
        table.put(6, "A++++"); // 6 => A will be overrode to 6 => A++++

        System.out.println("SEE RESULT USING DEBUGGER TO SEE ALL VALUES IMMEDIATELY");

        System.out.println(table.get(6));

        table.remove(6);
        table.remove(999); // will throw error!
    }
}
