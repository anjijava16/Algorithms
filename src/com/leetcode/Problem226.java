package com.leetcode;

/**
 * Created by sunilpatil on 12/8/16.
 */
public class Problem226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        Problem226.TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        if (root.left != null)
            invertTree(root.left);
        if (root.right != null)
            invertTree(root.right);
        return root;
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
