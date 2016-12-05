package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 12/1/16.
 */
public class Problem23Test {
    Problem23 problem;

    @Before
    public void setup() {
        problem = new Problem23();
    }

    @Test
    public void testWithNullList() {
        Problem23.ListNode mergedNode = problem.mergeKLists(null);
        assert mergedNode == null;
    }

    @Test
    public void testWithSingleList() {

        Problem23.ListNode oddNode = new Problem23.ListNode(1);
        oddNode.next = new Problem23.ListNode(3);
        oddNode.next.next = new Problem23.ListNode(5);

        Problem23.ListNode[] lists = new Problem23.ListNode[1];
        lists[0] = oddNode;
        Problem23.ListNode mergedNode = problem.mergeKLists(lists);
        assert mergedNode != null;
        assert mergedNode.val == 1;
    }

    @Test
    public void testMerge2ListWithInterMixedData() {
        Problem23.ListNode evenNode = new Problem23.ListNode(2);
        evenNode.next = new Problem23.ListNode(4);
        evenNode.next.next = new Problem23.ListNode(6);

        Problem23.ListNode oddNode = new Problem23.ListNode(1);
        oddNode.next = new Problem23.ListNode(3);
        oddNode.next.next = new Problem23.ListNode(5);

        Problem23.ListNode mergedNode = problem.merge2List(evenNode, oddNode);

        assert mergedNode.val == 1;
        assert mergedNode.next.val == 2;
        assert mergedNode.next.next.val == 3;
        assert mergedNode.next.next.next.val == 4;
        assert mergedNode.next.next.next.next.val == 5;
        assert mergedNode.next.next.next.next.next.val == 6;

    }

    @Test
    public void testMerge2ListWithOneAfterAnotherData() {
        Problem23.ListNode evenNode = new Problem23.ListNode(1);
        evenNode.next = new Problem23.ListNode(2);
        evenNode.next.next = new Problem23.ListNode(3);

        Problem23.ListNode oddNode = new Problem23.ListNode(4);
        oddNode.next = new Problem23.ListNode(5);
        oddNode.next.next = new Problem23.ListNode(6);


        Problem23.ListNode mergedNode = problem.merge2List(evenNode, oddNode);

        assert mergedNode.val == 1;
        assert mergedNode.next.val == 2;
        assert mergedNode.next.next.val == 3;
        assert mergedNode.next.next.next.val == 4;
        assert mergedNode.next.next.next.next.val == 5;
        assert mergedNode.next.next.next.next.next.val == 6;

    }

    @Test
    public void testMerge2Nodes() {
        Problem23.ListNode evenNode = new Problem23.ListNode(2);
        evenNode.next = new Problem23.ListNode(4);
        evenNode.next.next = new Problem23.ListNode(6);

        Problem23.ListNode oddNode = new Problem23.ListNode(1);
        oddNode.next = new Problem23.ListNode(3);
        oddNode.next.next = new Problem23.ListNode(5);

        Problem23.ListNode[] listNodes = new Problem23.ListNode[2];
        listNodes[0] = evenNode;
        listNodes[1] = oddNode;

        Problem23.ListNode mergedNode = problem.mergeKLists(listNodes);

        assert mergedNode.val == 1;
        assert mergedNode.next.val == 2;
        assert mergedNode.next.next.val == 3;
        assert mergedNode.next.next.next.val == 4;
        assert mergedNode.next.next.next.next.val == 5;
        assert mergedNode.next.next.next.next.next.val == 6;
    }

    @Test
    public void testMergeMultipleSingleElementLists() {
        Problem23.ListNode[] lists = new Problem23.ListNode[10];
        lists[0] = new Problem23.ListNode(7);
        lists[1] = new Problem23.ListNode(49);
        lists[2] = new Problem23.ListNode(73);
        lists[3] = new Problem23.ListNode(58);
        lists[4] = new Problem23.ListNode(30);
        lists[5] = new Problem23.ListNode(72);
        lists[6] = new Problem23.ListNode(44);
        lists[7] = new Problem23.ListNode(78);
        lists[8] = new Problem23.ListNode(23);
        lists[9] = new Problem23.ListNode(9);
        Problem23.ListNode mergedNode = problem.mergeKLists(lists);

        assert mergedNode.val == 7;
        assert mergedNode.next.val == 9;
        assert mergedNode.next.next.val == 23;


    }

    @Test
    public void testMerge2EmptyLists() {
        Problem23.ListNode[] lists = new Problem23.ListNode[2];
        Problem23.ListNode mergedNode = problem.mergeKLists(lists);
        assert mergedNode == null;
    }

    @Test
    public void testMerge2ListComplex() {
        Problem23.ListNode evenNode = new Problem23.ListNode(-1);
        evenNode.next = new Problem23.ListNode(-1);
        evenNode.next.next = new Problem23.ListNode(-1);

        Problem23.ListNode oddNode = new Problem23.ListNode(-2);
        oddNode.next = new Problem23.ListNode(-2);
        oddNode.next.next = new Problem23.ListNode(-1);


        Problem23.ListNode mergedNode = problem.merge2List(evenNode, oddNode);

        assert mergedNode.val == -2;
        assert mergedNode.next.val == -2;
        assert mergedNode.next.next.val == -1;
        assert mergedNode.next.next.next.val == -1;
        assert mergedNode.next.next.next.next.val == -1;
        assert mergedNode.next.next.next.next.next.val == -1;

    }

}
