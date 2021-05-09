package com.ishakssite;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int item) {
        var node = new Node(item); // create a node

        if (isEmpty()) first = last = node; // if empty just insert the node without worrying about referencing next node!
        else {
            last.next = node; // otherwise, don't worry about the first one, just worry about the last one!
            last = node; // promote the new node as the last node!
        }

        size++;
    }

    public void addFirst(int item) {
        var node = new Node(item); // create a node

        if (isEmpty()) first = last = node; // if empty just insert the node without worrying about referencing the next node!
        else {
            node.next = first; // otherwise, don't worry about the last one, just worry about the first one!
            first = node; // promote the new node as first node!
        }

        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while(current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1; // indexOf() method is implemented above this method!
    }

    public void removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) { // if only 1 element, this is how you remove it!
            first = last = null;
            size = 0;
            return;
        }

        var second = first.next; // when you remove first, someone needs to be the first!
        first.next = null;
        first = second;

        size--;
    }

    public void removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }

        var previous = getPrevious(last); // when you remove last, someone else need to be the last!
        last = previous; // informal but right: since you've worked too hard to remove last where you need to traverse the entire list, when you get previous node, right away you can make it last!
        last.next = null; // when someone becomes the last node, last.next need to be null!

        size--;
    }

    private Node getPrevious(Node node) {
        var current = first;

        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        if (isEmpty()) return; // don't throw exception cause it's not the end of the world if someone wanna reverse an empty linked list!

        // [10 <- 20 <- 30]
        //               p     c     n   <<< in last iteration, it'll be like this!
        var previous = first; // in p  c  n, start with p and c first when reversing a linked list!
        var current = first.next;
        while (current != null) { // logic for changing the direction of the links!
            var next = current.next; // hold this
            current.next = previous; // reverse the link
            previous = current; // moving references one step forward > previous    current    next
            // make sure you write above line first before writing the line below
            current = next;
        }

        last = first;
        last.next = null;
        first = previous; // cause in the last iteration it'll be > p   c   n, where p or previous is the last node (c is null) which I'm assigning as first here!
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty()) throw new IllegalStateException();

        var a = first;
        var b = first;
        for (int i = 0; i < k-1; i++) { // moving b forward until it is at the right distance from a!
            b = b.next;
            if (b == null) // means k is greater than size of linked list!
                throw new IllegalArgumentException();
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public void printMiddle() {
        if (isEmpty()) throw new IllegalStateException();

        var a = first;
        var b = first;
        // informal but works: condition inside the following while loop, you're kinda reserving 2 place, b and b.next!
        while (b != last && b.next != last) { // If the list has an even number of nodes, at the end of the last iteration, the second pointer will reference the tail node, means the second pointer will be b.next
            b = b.next.next;
            a = a.next;
        }

        if (b == last) System.out.println(a.value); // means one middle node, but for the next line 2 middle node
        else System.out.println(a.value + ", " + a.next.value); // also print node to the right of the left middle node!
    }

    public static LinkedList createWithLoop() {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }

    public boolean hasLoop() {
        var slow = first;
        var fast = first;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}