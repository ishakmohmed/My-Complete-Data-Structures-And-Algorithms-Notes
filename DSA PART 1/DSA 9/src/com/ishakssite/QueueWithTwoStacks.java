package com.ishakssite;
import java.util.Stack;

public class QueueWithTwoStacks {
    // Queue
    // Stack1     < for enqueue
    // Stack2     < for dequeue
    // rule of thumb: only move items from stack1 to stack2 if stack2 is empty!

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        if (stack2.isEmpty()) // we're kinda expecting this to happen!
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        return stack2.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        if (stack2.isEmpty()) // we're kinda expecting this!
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
