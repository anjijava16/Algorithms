package com.leetcode;

import java.util.Stack;

/**
 * 61. Rotate List
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * Created by sunilpatil on 11/30/16.
 */
public class Problem61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        int listLength = getListLength(head);
        if (k == listLength)
            return head;
        if (k / listLength >= 1)
            k = k % listLength;
        else if (k > listLength)
            k = k - listLength;
        Stack<ListNode> stack = new Stack<>();
        int counter = 1;
        ListNode l = head;
        while (l != null) {
            if (counter >= (listLength - k))
                stack.push(l);
            counter = counter + 1;
            l = l.next;
        }
        while (stack.size() != 1) {
            ListNode oldHead = head;
            head = stack.pop();
            head.next = oldHead;
        }
        ListNode lastNode = stack.pop();
        lastNode.next = null;
        return head;
    }

    private int getListLength(ListNode head) {
        int count = 0;
        ListNode next = head;
        while (next != null) {
            count = count + 1;
            next = next.next;
        }
        return count;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
