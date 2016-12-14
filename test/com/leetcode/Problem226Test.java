package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 12/9/16.
 */
public class Problem226Test {
    Problem226 problem;

    @Before
    public void setup() {
        problem = new Problem226();
    }

    @Test
    public void testSimple() {
        Problem226.TreeNode headNode = new Problem226.TreeNode(10);
        headNode.left = new Problem226.TreeNode(5);
        headNode.right = new Problem226.TreeNode(15);

        Problem226.TreeNode invertedNode = problem.invertTree(headNode);

        assert invertedNode.val == 10;
        assert invertedNode.left.val == 15;
        assert invertedNode.right.val == 5;

    }

    @Test
    public void testSimple2() {
        Problem226.TreeNode headNode = new Problem226.TreeNode(4);
        headNode.left = new Problem226.TreeNode(2);
        headNode.right = new Problem226.TreeNode(7);

        headNode.left.left = new Problem226.TreeNode(1);
        headNode.left.right = new Problem226.TreeNode(3);

        headNode.right.left = new Problem226.TreeNode(6);
        headNode.right.right = new Problem226.TreeNode(9);

        Problem226.TreeNode invertedNode = problem.invertTree(headNode);
        assert invertedNode.val == 4;
        assert invertedNode.left.val == 7;
        assert invertedNode.right.val == 2;

        assert invertedNode.left.left.val == 9;
        assert invertedNode.left.right.val == 6;
        assert invertedNode.right.left.val == 3;
        assert invertedNode.right.right.val == 1;

    }
}
