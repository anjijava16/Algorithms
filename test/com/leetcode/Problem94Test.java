package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunilpatil on 12/22/16.
 */
public class Problem94Test {
    Problem94 problem;

    @Before
    public void setup() {
        problem = new Problem94();
    }

    @Test
    public void testSimple() {
        Problem94.TreeNode head = new Problem94.TreeNode(1);
        head.right = new Problem94.TreeNode(2);
        head.right.left = new Problem94.TreeNode(3);
        List<Integer> returnList = problem.inorderTraversal(head);
        assert returnList.size() == 3;
        assert returnList.get(0) == 1;
        assert returnList.get(1) == 3;
        assert returnList.get(2) == 2;

    }
}
