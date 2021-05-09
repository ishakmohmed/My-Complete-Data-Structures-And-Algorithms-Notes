package com.ishakssite;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    // In this project, we're building Array class from scratch!

    public static void main(String[] args) {
        var numbers = new Array(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.insert(50);
        numbers.insert(60);
        numbers.insert(70);

        numbers.print();
        System.out.println("---------------");

        numbers.removeAt(0);

        numbers.print();
        System.out.println("---------------");

        System.out.println(numbers.indexOf(20));
        System.out.println("^ Should be 0");

        System.out.println(numbers.max()); // works!

        System.out.println("Hello Hello Hello Hello Hello Hello Hello");

        System.out.println(Arrays.toString(numbers.intersect(new int[]{8, 30, 10, 15, 40}))); // works!

        var numbers2 = new Array(5);
        numbers2.insert(1);
        numbers2.insert(2);
        numbers2.insert(3);
        numbers2.insert(4);
        numbers2.insert(5);
        numbers2.print();
        System.out.println("Lets see if this array- 12345 gets reversed!");
        System.out.println(Arrays.toString(numbers2.reverse()));  // works, too perfect!

        // *********************************************************

        // NOTE: Vector<E> and ArrayList<E> are two dynamic arrays in Java!
        // Vector: grows 100% when full, also it's synchronized (when a method in synchronized, only 1 thread can access it)
        // ArrayList: grows 50% when full, THIS ONE IS NOT SYNCHRONIZED UNLIKE VECTOR!
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(0); // remove index or object!
        list.indexOf(30);
        list.lastIndexOf(30);
        list.contains(30);
        list.size(); // number of items
        list.toArray(); // will convert this list to regular array object;

        // **********************************************************

        System.out.println("**********************************************");
        System.out.println("**********************************************");

        var hello = new Array(5);

        hello.insert(200);
        hello.insert(300);
        hello.insert(500);

        hello.insertAt(400, 2);

        hello.print();
    }
}
