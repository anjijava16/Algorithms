package com.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 107. Binary Tree Level Order Traversal II   Add to List QuestionEditorial Solution
 * Created by sunilpatil on 12/8/16.
 */
public class Problem107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        levelOrderBottom(levelOrderList, root, 0);
        Collections.reverse(levelOrderList);
        return levelOrderList;
    }

    public void levelOrderBottom(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null)
            return;
        if (result.size() <= level)
            result.add(new ArrayList<Integer>());
        result.get(level).add(root.val);
        levelOrderBottom(result, root.left, level + 1);
        levelOrderBottom(result, root.right, level + 1);
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
