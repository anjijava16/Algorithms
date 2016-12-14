package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * Created by sunilpatil on 12/8/16.
 */
public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
        levelOrder(levelOrderList, root, 0);
        return levelOrderList;
    }

    public void levelOrder(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null)
            return;
        if (result.size() <= level)
            result.add(new ArrayList<Integer>());
        result.get(level).add(root.val);
        levelOrder(result, root.left, level + 1);
        levelOrder(result, root.right, level + 1);
    }

    void printLevelOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        printLevelOrderTraversal(root.left);
        printLevelOrderTraversal(root.right);
    }

    void printLevelOrderTraversalWithLevel(TreeNode root) {
        printLevelOrderTraversal(root, 0);
    }

    void printLevelOrderTraversal(TreeNode root, int level) {
        if (root == null)
            return;
        System.out.println("Level " + level + " Value " + root.val);
        printLevelOrderTraversal(root.left, level + 1);
        printLevelOrderTraversal(root.right, level + 1);
    }

    void printLevelOrderTraversalNR(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentElement = queue.poll();
            System.out.println("Queue " + currentElement.val);
            if (currentElement.left != null)
                queue.add(currentElement.left);
            if (currentElement.left != null)
                queue.add(currentElement.right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
