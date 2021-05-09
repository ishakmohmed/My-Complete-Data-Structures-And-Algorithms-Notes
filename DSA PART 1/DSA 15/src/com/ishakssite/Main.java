package com.ishakssite;
import java.util.HashMap;
import java.util.Map;

public class Main {
    // HASH FUNCTIONS!

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("MC190408835", "Ishak");
        System.out.println(hash("MC190408835"));
    }

    public static int hash(String key) {
        int hash = 0;
        for (var ch : key.toCharArray())
            hash += ch; // 0 += ASCII number
        return hash % 100; // because we're assuming that we're storing this in an array with capacity of 100
    }
}
