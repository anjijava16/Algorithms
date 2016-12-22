package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilpatil on 12/22/16.
 */
public class Problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> returnList = new ArrayList<>();
        inorderTraversal(root, returnList);
        return returnList;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
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
