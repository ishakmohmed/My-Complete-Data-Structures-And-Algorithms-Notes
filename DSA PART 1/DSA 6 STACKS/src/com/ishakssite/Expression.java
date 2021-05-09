package com.ishakssite;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{'); // cause you can't include value in constructor of ArrayList!
    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) { // In Java you can't use for each loop on a String unless you convert it to char array!
            if (isLeftBracket(ch))
                stack.push(ch); // ONLY LEFT BRACKETS GO INSIDE!

            if (isRightBracket(ch)) {
                if (stack.empty())
                    return false; // cause sometimes, it'll be ")1 + 2(", and you know, only left brackets would be pushed to the stack!

                var top = stack.pop();
                if (!bracketsMatch(top, ch))
                    return false;
            }
        }

        return stack.empty();
    }

    public boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    public boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
