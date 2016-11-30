package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 414. Third Maximum Number
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * <p>
 * Example 1:
 * Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * Created by sunilpatil on 11/29/16.
 */
public class Problem414 {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(nums.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o2 < o1)
                    return -1;
                return 1;
            }
        });
        for (int n : nums) {
            if (priorityQueue.contains(n) == false)
                priorityQueue.add(n);
        }
        if (priorityQueue.size() < 3)
            return priorityQueue.poll();

        for (int i = 0; i < 2; i++) {
            int currentElement = priorityQueue.poll();

        }

        return priorityQueue.poll();
    }
}
