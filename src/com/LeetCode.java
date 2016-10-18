package com;

import java.util.HashSet;

/**
 * Created by sunilpatil on 10/16/16.
 */
public class LeetCode {

    public static void main(String[] argv) {
        LeetCode leetCode = new LeetCode();

        int[] dups = new int[]{1, 2, 1, 3, 3};
        System.out.println(leetCode.singleNumber1(dups));
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

    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     */

    public int singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (!hs.contains(nums[i])) {
                hs.add(nums[i]);
            } else
                hs.remove(nums[i]);
        }
        if (!hs.isEmpty() && hs.size() == 1)
            return hs.iterator().next();
        else
            return -1;
    }

    public int singleNumber1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
            System.out.println(res);
        }
        return res;
    }
}
