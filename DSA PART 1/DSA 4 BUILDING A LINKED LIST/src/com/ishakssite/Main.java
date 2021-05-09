package com.ishakssite;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // note in ArrayList, not Linked List, you can set the initial capacity like => new ArrayList(100)!

        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        System.out.println(list.indexOf(30));

        System.out.println(list.contains(10));

        list.removeFirst(); // will remove 10!
        list.removeFirst(); // will remove 30!

        System.out.println(list.size());

        list.toArray(); // will convert this list to array!

        var anotherList = new LinkedList();
        anotherList.addLast(555);
        anotherList.addLast(556);
        anotherList.addLast(557);
        anotherList.addLast(558);
        anotherList.addLast(559);

        anotherList.reverse(); // the linked list is reversed, it works!
        var theList = anotherList.toArray();
        System.out.println(Arrays.toString(theList));

        System.out.println("The last node is this list is " + anotherList.getKthFromTheEnd(1));
    }
}
