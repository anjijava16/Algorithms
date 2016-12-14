package com.leetcode;

/**
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Created by sunilpatil on 12/8/16.
 */
public class Problem98 {
    public boolean isValidBST2(TreeNode root) {
        if (root == null)
            return true;

        if (root.left != null && root.left.val >= root.val)
            return false;
        else if (root.right != null && root.right.val <= root.val)
            return false;

        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        System.out.println("Root val " + root.val + " min " + min + " max " + max);
        if (root.val <= min || root.val >= max)
            return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }


    public static class TreeNode {
        int val;
        Problem98.TreeNode left;
        Problem98.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
