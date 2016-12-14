package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunilpatil on 12/8/16.
 */
public class Problem102Test {

    Problem102 problem;

    @Before
    public void setup() {
        problem = new Problem102();
    }

    @Test
    public void testLevelOrderRight() {
        Problem102.TreeNode rootNode = new Problem102.TreeNode(3);
        rootNode.left = new Problem102.TreeNode(9);
        rootNode.right = new Problem102.TreeNode(20);
        rootNode.right.left = new Problem102.TreeNode(15);
        rootNode.right.right = new Problem102.TreeNode(7);

        List<List<Integer>> returnList = problem.levelOrder(rootNode);
        assert returnList.size() == 3;
        assert returnList.get(0).get(0) == 3;
        assert returnList.get(1).get(0) == 9;
        assert returnList.get(1).get(1) == 20;
    }

    @Test
    public void testLevelOrderBalanced() {
        Problem102.TreeNode rootNode = new Problem102.TreeNode(3);
        rootNode.left = new Problem102.TreeNode(9);
        rootNode.right = new Problem102.TreeNode(20);
        rootNode.left.left = new Problem102.TreeNode(5);
        rootNode.left.right = new Problem102.TreeNode(4);

        rootNode.right.left = new Problem102.TreeNode(15);
        rootNode.right.right = new Problem102.TreeNode(7);

        List<List<Integer>> returnList = problem.levelOrder(rootNode);
        System.out.println(returnList);
        assert returnList.size() == 3;
        assert returnList.get(0).get(0) == 3;
        assert returnList.get(1).get(0) == 9;
        assert returnList.get(1).get(1) == 20;
    }

    @Test
    public void testPrintInOrderTraversal() {
        Problem102.TreeNode rootNode = new Problem102.TreeNode(3);
        rootNode.left = new Problem102.TreeNode(9);
        rootNode.right = new Problem102.TreeNode(20);
        rootNode.right.left = new Problem102.TreeNode(15);
        rootNode.right.right = new Problem102.TreeNode(7);

        problem.printLevelOrderTraversalWithLevel(rootNode);
    }

    @Test
    public void testPrintInOrderTraversalNR() {
        Problem102.TreeNode rootNode = new Problem102.TreeNode(3);
        rootNode.left = new Problem102.TreeNode(9);
        rootNode.right = new Problem102.TreeNode(20);
        rootNode.right.left = new Problem102.TreeNode(15);
        rootNode.right.right = new Problem102.TreeNode(7);

        problem.printLevelOrderTraversalNR(rootNode);
    }


}
