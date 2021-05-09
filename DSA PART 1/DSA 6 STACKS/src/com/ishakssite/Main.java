package com.ishakssite;

public class Main {

    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        System.out.println(stack);
//        var top = stack.pop(); // removes from top of list and also returns that value!
//        System.out.println(top);
//        System.out.println(stack);
//        top = stack.peek();
//
//        // in Java, there is another method called search(Object o) but Mosh never used it and he said that most probably I'm not gonna use it at all, cause stacks aren't meant for storing objects and looking them up quickly!
//        // there is also another method called empty, which tells you if the stack is empty >>>
//        System.out.println(stack.empty());

        var reverser = new StringReverser();
        System.out.println(reverser.reverse("Mohmed Ishak"));

        // Balanced expressions >>>
        // Edge cases >>>
        // (
        // (()
        // ( ]
        // ) (

        String str = "(1 + 2)";
        var exp = new Expression();
        var result = exp.isBalanced(str);
        System.out.println(result);

        // -----------------------------------------------------

        Stack stack = new Stack(); // my own stack!
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        System.out.println(stack); // println() will call the toString method which I have overrode!

        System.out.println(stack.peek());
    }}
