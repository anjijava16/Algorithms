package com.algo4.misc;

/**
 * Created by sunilpatil on 10/10/16.
 */
public class TestBinaryTree {
    public static void main(String[] argv) {
        Node root = new Node();
        root.data = 1;
        root.left = new Node();
        root.left.data = 2;
        //   root.right = new Node();
        //   root.right.data = 2;
        //   root.left.left = new Node();
        //   root.left.left.data = 8;
        //    root.left.right = new Node();
        //    root.left.right.data = 12;

        TestBinaryTree testBinaryTree = new TestBinaryTree();
        System.out.println(testBinaryTree.checkBST(root));
    }

    boolean checkBST(Node root) {
        if (root == null)
            return true;
        if (checkLeft(root, root.left) == false)
            return false;
        else if (checkRight(root, root.right) == false)
            return false;
        else if (checkBST(root.left) == false)
            return false;
        else if (checkBST(root.right) == false)
            return false;
        else
            return true;
    }

    boolean checkLeft(Node root, Node left) {
        if (left == null)
            return true;
        if (root.data > left.data) {
            return true;
        } else
            return false;

    }

    boolean checkRight(Node root, Node right) {
        if (right == null)
            return true;
        if (root.data < right.data) {
            return true;
        } else
            return false;

    }

    static class Node {
        int data;
        Node left;
        Node right;
    }
}
