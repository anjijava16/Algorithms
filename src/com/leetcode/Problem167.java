package com.leetcode;

/**
 * Created by sunilpatil on 11/12/16.
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Problem167 {
    public int[] twoSum(int[] num, int target) {
        for (int i = 0; i < num.length; i++) {
            int first = num[i];
            int secondNum = target - first;
            int second = binarySearchRecursive(num, i + 1, num.length, secondNum);
            if (second != -1)
                return new int[]{i + 1, second + 1};
        }
        return null;
    }

    public int binarySearchRecursive(int[] a, int lo, int hi, int t) {

        if (lo > hi)
            return -1;

        int mid = lo + ((hi - lo) / 2);
        if (a[mid] == t)
            return mid;
        else if (t < a[mid]) {
            return binarySearchRecursive(a, lo, mid - 1, t);
        } else if (t > a[mid]) {
            return binarySearchRecursive(a, mid + 1, hi, t);
        }
        return -1;
    }
}
