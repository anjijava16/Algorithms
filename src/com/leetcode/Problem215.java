package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * Created by sunilpatil on 11/29/16.
 */
public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2 < o1)
                    return -1;
                return 1;
            }
        });
        for (int n : nums) {
            priorityQueue.add(n);
        }
        for (int i = 1; i < k; i++)
            System.out.println("Throwing out element " + priorityQueue.poll());
        return priorityQueue.poll();
    }
}
