package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunilpatil on 12/22/16.
 */
public class Problem144Test {
    Problem144 problem;

    @Before
    public void setup() {
        problem = new Problem144();
    }

    @Test
    public void testSimple() {
        Problem144.TreeNode head = new Problem144.TreeNode(1);
        head.right = new Problem144.TreeNode(2);
        head.right.left = new Problem144.TreeNode(3);
        List<Integer> returnList = problem.preorderTraversal(head);
        assert returnList.size() == 3;
        assert returnList.get(0) == 1;
        assert returnList.get(1) == 2;
        assert returnList.get(2) == 3;
    }
}
