package com;

import java.util.Arrays;

/**
 * Created by sunilpatil on 10/16/16.
 */
public class LeetCode {

    public static void main(String[] argv) {
        int[] nums = new int[]{3, 2, 2, 3};
        LeetCode leetCode = new LeetCode();
        System.out.println(leetCode.removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Given an array and a value, remove all instances of that value in place and return the new length.
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            if (nums[start] == val) {
                nums[start] = nums[--end];
                nums[end] = 0;
                continue;
            }
            start++;
        }
        return end;
    }
}
