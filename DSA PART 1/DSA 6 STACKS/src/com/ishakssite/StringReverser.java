package com.ishakssite;
import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if (input == null) throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) // in Java, you cannot use for each loop on a String, hence this line!
            stack.push(ch);

        StringBuffer reversed = new StringBuffer(); // cause str in Java is immutable, so if you have lots of concatenations, you need to allocate memory unless you use StringBuffer!
        while (!stack.empty())
            reversed.append(stack.pop());

        return reversed.toString();
    }
}
