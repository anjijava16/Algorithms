package com.leetcode;

import java.util.*;

/**
 * 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * Created by sunilpatil on 12/5/16.
 */
public class Problem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> uniqueList = new HashSet<>();
        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int secondNum = nums[j];
                int thirdNum = 0 - (firstNum + secondNum);
                int lookup = binarySearchRecursive(nums, j + 1, nums.length - 1, thirdNum);

                if (lookup != -1) {
                    List<Integer> occurance = new ArrayList<>();
                    occurance.add(firstNum);
                    occurance.add(secondNum);
                    occurance.add(thirdNum);
                    Collections.sort(occurance);
                    if (!uniqueList.contains(occurance)) {
                        uniqueList.add(occurance);
                        returnList.add(occurance);
                    }
                }


            }
        }
        return returnList;
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
