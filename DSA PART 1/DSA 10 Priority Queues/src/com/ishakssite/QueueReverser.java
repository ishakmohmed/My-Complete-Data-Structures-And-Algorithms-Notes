package com.ishakssite;
import java.util.Queue;
import java.util.Stack;

//1- Given an integer K and a queue of integers,
//write code to reverse the order of the first K elements of the queue.
//Input:  Q = [10, 20, 30, 40, 50], K = 3
//Output: Q = [30, 20, 10, 40, 50]

// MOSH'S ANSWER >>>

public class QueueReverser {
    public static void reverse(Queue<Integer> queue, int k) {
        if (k < 0 || k > queue.size())
            throw new IllegalArgumentException();

        Stack<Integer> stack = new Stack<>();

        // Dequeue the first K elements from the queue
        // and push them onto the stack
        for (int i = 0; i < k; i++)
            stack.push(queue.remove());

        // Enqueue the content of the stack at the
        // back of the queue
        while (!stack.empty())
            queue.add(stack.pop());

        // Add the remaining items in the queue (items
        // after the first K elements) to the back of the
        // queue and remove them from the beginning of the queue
        for (int i = 0; i < queue.size() - k; i++)
            queue.add(queue.remove());
    }
}
