package com.ishakssite;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // LinkedList<Integer>   // <<< Without <>, you can store any objects in each node (like you can mix the hell out of every nodes)!

        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        System.out.println(list);

        list.addFirst(5);

        System.out.println(list);
        list.removeFirst();
        list.removeLast();
        list.remove(3); // index;

        System.out.println(list);

        list.contains(10);
        list.indexOf(10); // first occurrence, I GUESS YOU HAVE LAST INDEX OF TOO!

        list.size(); // number of items

        var array = list.toArray();
        System.out.println("LIST IS NOW CONVERTED TO ARRAY");
        System.out.println(Arrays.toString(array));
    }
}
