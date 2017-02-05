package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 1/2/17.
 */
public class Problem404Test {
    Problem404 problem;

    @Before
    public void setup() {
        problem = new Problem404();
    }

    @Test
    public void simpleTest() {
        Problem404.TreeNode root = new Problem404.TreeNode(3);
        root.left = new Problem404.TreeNode(9);
        root.right = new Problem404.TreeNode(20);
        root.right.left = new Problem404.TreeNode(15);
        root.right.right = new Problem404.TreeNode(7);

        assert problem.sumOfLeftLeaves(root) == 24;
    }
}
