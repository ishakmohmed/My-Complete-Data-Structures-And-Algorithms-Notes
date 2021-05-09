package com.ishakssite;

public class Main {
    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//
//        queue.add(5);
//        queue.add(1);
//        queue.add(3);
//        queue.add(2);
//
//        while (!queue.isEmpty())
//            System.out.println(queue.remove()); // will print 1, 2, 3, 5!

        PriorityQueue q = new PriorityQueue(); // my custom priority queue!
        q.add(5);
        q.add(3);
        q.add(6);
        q.add(1);
        q.add(4);
        System.out.println(q);

        while (!q.isEmpty())
            System.out.println(q.remove()); // biggest will come out first in this custom implementation unlike actual priority queue!
    }
}
