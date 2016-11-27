package com.leetcode;

import java.util.Arrays;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class Problem41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int counter = 0;
        while (nums[counter] < 1) {
            counter++;
        }
        for (int i = counter; i < nums.length - 1; i++) {

            if (nums[i] != i - counter)
                return i - counter;
        }
        return nums[nums.length - 1] + 1;
    }
}
