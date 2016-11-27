package com.leetcode;

import java.util.HashSet;

/**
 * Created by sunilpatil on 11/26/16.
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class Problem217 {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> h = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (h.contains(nums[i]))
                return true;
            h.add(nums[i]);
        }
        return false;
    }


}
