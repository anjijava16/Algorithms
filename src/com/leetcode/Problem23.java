package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Created by sunilpatil on 11/29/16.
 */
public class Problem23 {
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                return 1;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode currentNode = lists[i];

            while (currentNode != null) {
                priorityQueue.add(currentNode);
                currentNode = currentNode.next;
            }
        }
        ListNode headNode = null;
        ListNode nextNode = null;
        if (priorityQueue.size() != 0) {
            headNode = priorityQueue.poll();
            nextNode = headNode;
            while (!priorityQueue.isEmpty()) {
                nextNode.next = priorityQueue.poll();
                nextNode = nextNode.next;
            }
        }

        return headNode;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        ListNode returnNode = lists[0];
        for (int i = 1; i < lists.length; i++) {
            returnNode = merge2List(returnNode, lists[i]);
        }
        return returnNode;
    }

    // Merge 2 lists at a time using MergeSort type of logic
    public ListNode merge2List(ListNode firstNext, ListNode secondNext) {
        ListNode returnHead = null;

        if (firstNext == null && secondNext == null)
            return null;
        else if (firstNext == null)
            return secondNext;
        else if (secondNext == null)
            return firstNext;
        //Optimization for cases where both lists have single element
        if (firstNext.next == null && secondNext.next == null) {
            if (firstNext.val < secondNext.val) {
                returnHead = new ListNode(firstNext.val);
                returnHead.next = new ListNode(secondNext.val);
            } else {
                returnHead = new ListNode(secondNext.val);
                returnHead.next = new ListNode(firstNext.val);
            }
            return returnHead;
        }
        ListNode mergedNodeNext = null;

        while (firstNext != null || secondNext != null) {
            ListNode nextNode = new ListNode(0);
            if (firstNext == null) {
                nextNode.val = secondNext.val;
                secondNext = secondNext.next;
            } else if (secondNext == null) {
                nextNode.val = firstNext.val;
                firstNext = firstNext.next;
            } else if (firstNext.val < secondNext.val) {
                nextNode.val = firstNext.val;
                firstNext = firstNext.next;
            } else {
                nextNode.val = secondNext.val;
                secondNext = secondNext.next;
            }
            if (returnHead == null) {
                returnHead = nextNode;
                mergedNodeNext = nextNode;
            } else {
                mergedNodeNext.next = nextNode;
                mergedNodeNext = nextNode;
            }

        }
        return returnHead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
