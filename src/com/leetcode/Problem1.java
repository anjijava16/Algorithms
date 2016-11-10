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
            int second = binarySearch(num, target - first);
            if (second != -1)
                return new int[]{i, second};
        }
        return null;
    }

    public int binarySearch(int[] a, int t) {
        int lo = 0;
        int hi = a.length;
        while (lo < hi) {
            int mid = lo + ((hi - lo) / 2);
            if (a[mid] == t)
                return mid;
            else if (t < a[mid]) {
                hi = mid - 1;
            } else if (t > a[mid]) {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
