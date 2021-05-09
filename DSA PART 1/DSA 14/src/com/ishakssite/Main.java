package com.ishakssite;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) { // this method: a little exposure to HashSet!
        Set<Integer> set = new HashSet<>(); // set contains only key by the way!
        int[] numbers = { 1, 2, 3, 2, 1, 4 };

        for (var number : numbers)
            set.add(number);

        System.out.println(set); // you have set.add(), remove(), set.removeAll(), .contains(), .size(), .clear, (etc?)
    }

    public static char findFirstRepeatedChar(String str) {
        Set<Character> set = new HashSet<>();

        for (var ch : str.toCharArray()) {
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
