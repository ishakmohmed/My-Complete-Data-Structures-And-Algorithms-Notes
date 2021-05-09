package com.ishakssite;

public class Main {

    public static void main(String[] args) {
//        Tree tree = new Tree();
//        tree.insert(7);
//        tree.insert(4);
//        tree.insert(1);
//        tree.insert(9);
//        tree.insert(6);
//        tree.insert(8);
//        tree.insert(10);
//        tree.traversePreOrder();
//        tree.traverseInOrder();
//        tree.traversePostOrder();
//
//        System.out.println("Hello");
//        System.out.println(tree.height());
//
//        System.out.println(tree.min()); // you'll see the minimum value in the tree

        Tree treeOne = new Tree();
        treeOne.insert(1);
        treeOne.insert(2);
        treeOne.insert(3);

        Tree treeTwo = new Tree();
        treeTwo.insert(1);
        treeTwo.insert(2);
        treeTwo.insert(3);

        System.out.println(treeOne.equals(treeTwo));
    }

    // RECURSION STARTS >>>>>>>

//    public static int factorial(int n) { // without recursion
//        var factorial = 1;
//        for (var i = n; i > 1; i--)
//            factorial *= i;
//        return factorial;
//    }

//    public static int factorial (int n) {
//        if (n == 0) return 1;
//
//        return n * factorial(n - 1);
//    }

    // RECURSION ENDS #######
}
