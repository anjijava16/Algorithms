package com.dsmadeeasy;

/**
 * Created by sunilpatil on 10/14/16.
 */
public class BinaryTree {
    TreeNode root;

    public static void main(String[] argv) {

        BinaryTree binaryTree = new BinaryTree();


        binaryTree.insert(10);
        binaryTree.insert(11);
        binaryTree.insert(12);
        binaryTree.insert(13);
        binaryTree.insert(14);
        binaryTree.insert(15);
        binaryTree.insert(16);
        binaryTree.insert(17);
        binaryTree.insert(18);
        binaryTree.insert(19);
        binaryTree.insert(20);

        System.out.println(binaryTree.get(11));
        System.out.println(binaryTree.get(17));
        System.out.println(binaryTree.get(1));
    }

    public void insert(int data) {
        insert(data, root);
    }

    public void insert(int data, TreeNode root) {
        if (root == null)
            this.root = new TreeNode(data);
        else {
            if (root.left == null)
                root.left = new TreeNode(data);
            else if (root.right == null)
                root.right = new TreeNode(data);
            else if (data % 2 == 0)
                insert(data, root.left);
            else
                insert(data, root.right);
        }
    }

    public boolean get(int data) {
        return get(data, root);
    }

    public boolean get(int data, TreeNode root) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        else
            return get(data, root.left) || get(data, root.right);
    }
}
