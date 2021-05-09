package com.ishakssite;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var ch = findFirstNonRepeatingChar("a green apple");
        System.out.println(ch);
    }

    public static char findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (var ch : str.toCharArray()) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (var ch : str.toCharArray())
            if (map.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE; // this is like a null character, not really null, but a non-existing character!
    }
}
