package com.ishakssite;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Mosh");
        map.put(2, "Ishak");
        map.put(3, "TechLead"); // you can override this by map.put(3, "Clement");

         // map.remove(3); // self-explanatory!
        System.out.println(map.get(3)); // since arg here in get() is key, the output will be value!

        // note: you can also store null KEY OR VALUES in hash maps!
        System.out.println("THE MAP IS >>>>>>>>");
        System.out.println(map);

        map.containsKey(3); // O(1)
        map.containsValue("Ishak"); // O(n), cause you can't rely on hash functions unlike above line, now you need to iterate through every line!

        System.out.println("ITERATIONS IN HASH MAPS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        // you can't iterate through map like for (var item: map), but if you chain keySet()- which returns a list of keys and entrySet()- which returns a list of key-value pairs to map, then you can iterate cause these 2 things are iterable!
        for (var item : map.keySet())
            System.out.println(item);

        for (var item : map.entrySet())
            System.out.println(item);

        for (var item : map.entrySet())
            System.out.println(item); // item here has getKey(), getValue(), and setValue(), etc.
    }
}
