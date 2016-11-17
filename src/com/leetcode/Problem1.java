package com.leetcode;

/**
 * Created by sunilpatil on 11/8/16.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Problem1 {


    public int[] twoSum(int[] num, int target) {
        for (int i = 0; i < num.length; i++) {
            int first = num[i];
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] + num[j] == target) {
                    System.out.printf("i -> %d j -> %d , num[i] ->%d, num[j] ->%d", i, j, num[i], num[j]);
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


}