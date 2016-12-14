package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 12/8/16.
 */
public class Problem98Test {
    Problem98 problem;

    @Before
    public void setup() {
        problem = new Problem98();
    }

    @Test
    public void testPositive() {
        Problem98.TreeNode headNode = new Problem98.TreeNode(2);
        headNode.left = new Problem98.TreeNode(1);
        headNode.right = new Problem98.TreeNode(3);

        assert problem.isValidBST(headNode) == true;
    }

    @Test
    public void testNegative() {
        Problem98.TreeNode headNode = new Problem98.TreeNode(1);
        headNode.left = new Problem98.TreeNode(2);
        headNode.right = new Problem98.TreeNode(3);

        assert problem.isValidBST(headNode) == false;

    }

    @Test
    public void testDuplicateLeftKey() {
        Problem98.TreeNode headNode = new Problem98.TreeNode(1);
        headNode.left = new Problem98.TreeNode(1);
        assert problem.isValidBST(headNode) == false;
    }

    @Test
    public void testDuplicateRighttKey() {
        Problem98.TreeNode headNode = new Problem98.TreeNode(1);
        headNode.right = new Problem98.TreeNode(1);
        assert problem.isValidBST(headNode) == false;
    }


    @Test
    public void testInvalidNestedTree() {
        Problem98.TreeNode headNode = new Problem98.TreeNode(10);
        headNode.left = new Problem98.TreeNode(5);
        headNode.right = new Problem98.TreeNode(15);

        headNode.right.left = new Problem98.TreeNode(6);
        headNode.right.right = new Problem98.TreeNode(20);

        assert problem.isValidBST(headNode) == false;
    }

    @Test
    public void testIntegerMaxValue() {
        Problem98.TreeNode headNode = new Problem98.TreeNode(Integer.MAX_VALUE);

        assert problem.isValidBST(headNode) == true;
    }

    @Test
    public void testIntegerinValue() {
        Problem98.TreeNode headNode = new Problem98.TreeNode(Integer.MIN_VALUE);

        assert problem.isValidBST(headNode) == true;
    }

    @Test
    public void test2MaxIntegerValues() {
        Problem98.TreeNode headNode = new Problem98.TreeNode(Integer.MAX_VALUE);
        headNode.left = new Problem98.TreeNode(Integer.MAX_VALUE);


        assert problem.isValidBST(headNode) == false;
    }

}
