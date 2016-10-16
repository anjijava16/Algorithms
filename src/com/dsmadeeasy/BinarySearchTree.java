package com.dsmadeeasy;

import java.util.*;

/**
 * Created by sunilpatil on 10/12/16.
 */
public class BinarySearchTree {


    private TreeNode root;

    public static void main(String[] argv) {
        BinarySearchTree integerBinarySearchTree = new BinarySearchTree();
        integerBinarySearchTree.insert(5);
        integerBinarySearchTree.insert(3);
        integerBinarySearchTree.insert(7);
        integerBinarySearchTree.insert(2);
        integerBinarySearchTree.insert(4);
        integerBinarySearchTree.insert(6);
        integerBinarySearchTree.insert(8);
        integerBinarySearchTree.insert(9);
        integerBinarySearchTree.insert(1);
        integerBinarySearchTree.insert(0);
        integerBinarySearchTree.insert(10);


        System.out.println("Height of the binary tree " + integerBinarySearchTree.height());

       /* Iterator it = integerBinarySearchTree.postOrder();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }*/

        integerBinarySearchTree.printLevelOrder();
    }

    /**
     * root -> left -> right
     *
     * @return
     */
    public Iterator<Integer> preOrder() {
        Queue<Integer> treeNodeQueue = new LinkedList<>();
        preOrder(root, treeNodeQueue);
        return treeNodeQueue.iterator();
    }

    public void preOrder(TreeNode root, Queue<Integer> queue) {
        if (root == null) {
            return;
        }
        queue.add(root.data);
        preOrder(root.left, queue);
        preOrder(root.right, queue);
    }

    public Iterator<Integer> preOrderNonRecursive() {
        Queue<Integer> treeNodeQueue = new LinkedList<>();
        if (root == null)
            return treeNodeQueue.iterator();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode treeNode = s.pop();
            treeNodeQueue.add(treeNode.data);
            if (treeNode.right != null)
                s.push(treeNode.right);
            if (treeNode.left != null)
                s.push(treeNode.left);
        }
        return treeNodeQueue.iterator();
    }

    // left -> root -> right
    public Iterator<Integer> inOrder() {
        Queue<Integer> treeNodeQueue = new LinkedList<>();
        inOrder(root, treeNodeQueue);
        return treeNodeQueue.iterator();
    }

    public void inOrder(TreeNode root, Queue<Integer> queue) {
        if (root == null)
            return;
        inOrder(root.left, queue);
        queue.add(root.data);
        inOrder(root.right, queue);
    }

    public Iterator<Integer> inOrderNonRecursive() {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;
        boolean done = false;
        while (!done) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (stack.isEmpty())
                    done = true;
                else {
                    currentNode = stack.pop();
                    res.add(currentNode.data);
                    currentNode = currentNode.right;
                }
            }
        }
        return res.iterator();
    }

    public Iterator<Integer> postOrder() {
        Queue<Integer> treeNodeQueue = new LinkedList<>();
        postOrder(root, treeNodeQueue);
        return treeNodeQueue.iterator();
    }

    public void postOrder(TreeNode root, Queue<Integer> queue) {
        if (root == null)
            return;
        postOrder(root.left, queue);
        postOrder(root.right, queue);
        queue.add(root.data);
    }

    public Iterator<Integer> postOrderNonRecursive() {
        ArrayList<Integer> res = new ArrayList<>();
        return res.iterator();
    }

    public Iterator<Integer> levelOrderTraversal() {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res.iterator();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        ArrayList<Integer> curr = new ArrayList<>();
        while (!queue.isEmpty()) {

        }

        return res.iterator();
    }

    /**
     * Calculate height of the tree
     *
     * @return
     */
    public int height() {
        return height(root);
    }

    public int height(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            //Figure out which side of the tree is longer and use that
            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

    public void printGivenLevel(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);

        }
    }

    public void printLevelOrder() {
        int height = height();
        for (int i = 1; i <= height; i++) {
            System.out.print("Level -> " + i + " -   > ");
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    public void insert(Integer data) {
        root = insert(data, root);
    }

    //Algorithm to find maximum element in a binary tree
    public int findMaximum(TreeNode root) {
        return 0;
    }

    public TreeNode get(int data) {
        return get(data, root);
    }

    public TreeNode get(int data, TreeNode root) {
        if (root == null)
            return null;
        //TODO: Complete this method
        //    if(data < root.data)
        return null;

    }

    public TreeNode insert(Integer data, TreeNode node) {
        if (node == null) {
            return new TreeNode(data);
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0)
            node.left = insert(data, node.left);
        else if (cmp > 0)
            node.right = insert(data, node.right);
        else
            node.data = data;
        return node;
    }
}
