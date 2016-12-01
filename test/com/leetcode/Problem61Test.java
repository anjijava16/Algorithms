package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/30/16.
 */
public class Problem61Test {
    Problem61 problem;

    @Before
    public void setup() {
        problem = new Problem61();
    }

    @Test
    public void testSimple() {
        Problem61.ListNode headNode = new Problem61.ListNode(1);
        headNode.next = new Problem61.ListNode(2);
        headNode.next.next = new Problem61.ListNode(3);
        headNode.next.next.next = new Problem61.ListNode(4);
        headNode.next.next.next.next = new Problem61.ListNode(5);
        Problem61.ListNode newHeadNode = problem.rotateRight(headNode, 2);

        assert newHeadNode.val == 4;
        assert newHeadNode.next.val == 5;
        assert newHeadNode.next.next.val == 1;

    }

    @Test
    public void testEmptyHead() {

        Problem61.ListNode newHeadNode = problem.rotateRight(null, 0);

        assert newHeadNode == null;

    }

    @Test
    public void testKEqualToLength() {
        Problem61.ListNode headNode = new Problem61.ListNode(1);
        headNode.next = new Problem61.ListNode(2);
        Problem61.ListNode newHeadNode = problem.rotateRight(headNode, 2);

        assert newHeadNode.val == 1;
        assert newHeadNode.next.val == 2;


    }

    @Test
    public void testKMoreThanLength() {
        Problem61.ListNode headNode = new Problem61.ListNode(1);
        headNode.next = new Problem61.ListNode(2);
        Problem61.ListNode newHeadNode = problem.rotateRight(headNode, 3);
        assert newHeadNode.val == 2;
        assert newHeadNode.next.val == 1;
    }

    @Test
    public void testKReallyLarge() {
        Problem61.ListNode headNode = new Problem61.ListNode(1);
        headNode.next = new Problem61.ListNode(2);
        headNode.next.next = new Problem61.ListNode(3);
        Problem61.ListNode newHeadNode = problem.rotateRight(headNode, 10);
        System.out.println("Return value " + newHeadNode);
        assert newHeadNode.val == 3;
        assert newHeadNode.next.val == 1;
        assert newHeadNode.next.next.val == 2;
    }
}
