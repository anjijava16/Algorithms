package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunilpatil on 12/8/16.
 */
public class Problem107Test {
    Problem107 problem;

    @Before
    public void setup() {
        problem = new Problem107();
    }

    @Test
    public void testSimple() {
        Problem107.TreeNode rootNode = new Problem107.TreeNode(3);
        rootNode.left = new Problem107.TreeNode(9);
        rootNode.right = new Problem107.TreeNode(20);
        rootNode.right.left = new Problem107.TreeNode(15);
        rootNode.right.right = new Problem107.TreeNode(7);

        List<List<Integer>> returnList = problem.levelOrderBottom(rootNode);
        System.out.println(returnList);
        assert returnList.size() == 3;
        assert returnList.get(0).get(0) == 15;
        assert returnList.get(0).get(1) == 7;
        assert returnList.get(1).get(0) == 9;
        assert returnList.get(1).get(1) == 20;
        assert returnList.get(2).get(0) == 3;

    }
}
