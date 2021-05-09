package com.ishakssite;

public class AVLTree {
    private class AVLNode {
        private int height;
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Value= " + this.value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null) return new AVLNode(value);
        if (value < root.value) root.leftChild = insert(root.leftChild, value);
        else root.rightChild = insert(root.rightChild, value);

        // with this recursive implementation, first we go down a tree
        // until we find the right place to insert this new node. Once we're
        // done, we're going to recursively go back up, on the way back off,
        // we'll update the height of every node until we get to the root node.

        setHeight(root);

        root = balance(root);
        return root; // informal but true: it'll return node at the bottom first and then progressively return stuffs and finally the top node
    }

    private AVLNode balance(AVLNode root) {
        // balance factor >>>
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        }
        else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root) {
        // 10
        //    20
        // 15    30
        var newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        //        10
        //    20
        // 30     15
        var newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }
}

// notes: detecting rotation
// let's assume a right heavy tree (for left heavy tree, this thing is opposite) >
// 10
//     20 (balanceFactor is -1)
//         30
// leftRotate(10)


// 10
//    30 (balanceFactor is 1) balanceFactor(root.right) > 0
// 20
// rightRotate(30)
// leftRotate(10)