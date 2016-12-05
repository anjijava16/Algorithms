package com.leetcode;

import java.util.HashSet;

/**
 * 26. Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example,
 * Given input array nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * Created by sunilpatil on 11/30/16.
 */
public class Problem26 {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        int j = nums.length - 1;

        while (i < nums.length && nums[i] != Integer.MIN_VALUE) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                i = i + 1;
            } else {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = Integer.MIN_VALUE;
                j = j - 1;
            }
        }
        return i;
    }

    public int removeDuplicates2(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                i = i + 1;
            } else {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = -1;
                j = j - 1;
            }
        }
        if (i + 1 != nums.length)
            return i + 1;
        return i;
    }
}
