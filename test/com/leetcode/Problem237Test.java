package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 12/10/16.
 */
public class Problem237Test {

    Problem237 problem;

    @Before
    public void setup() {
        problem = new Problem237();
    }


    @Test
    public void testSimple() {
        Problem237.ListNode listNode = new Problem237.ListNode(1);
        listNode.next = new Problem237.ListNode(2);
        listNode.next.next = new Problem237.ListNode(3);
        listNode.next.next.next = new Problem237.ListNode(4);

        problem.deleteNode(listNode.next.next);
        assert listNode.next.next.val == 4;
    }
}
