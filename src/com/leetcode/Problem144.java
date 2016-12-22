package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilpatil on 12/22/16.
 */
public class Problem144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> returnList = new ArrayList<>();
        preorderTraversal(root, returnList);
        System.out.println(returnList);
        return returnList;
    }

    public void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);

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
