package com.ishakssite;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.remove(); // will remove 10 (which you can capture) which stands in front of the queue!
        System.out.println(queue);
        reverse(queue);
        System.out.println(queue);
        System.out.println("LOL");

        // more methods >>>
        queue.element();
        queue.offer(99); // similar to add
        queue.peek();
        queue.poll();
        // etc... ? idk, I guess there is a method for empty and is a method for full too!

        // ----------------------------------------------------------

        ArrayQueue myArrayQueue = new ArrayQueue(5);
        myArrayQueue.enqueue(1);
        myArrayQueue.enqueue(2);
        myArrayQueue.enqueue(3);
        myArrayQueue.enqueue(4);
        myArrayQueue.enqueue(5);
        System.out.println(myArrayQueue);
        var front = myArrayQueue.dequeue();
        System.out.println(myArrayQueue);
        myArrayQueue.enqueue(99);
        System.out.println(myArrayQueue);
    }

    public static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}