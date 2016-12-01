package com.leetcode;

/**
 * 189. Rotate Array
 * Rotate an array of n elements to the right by k steps.
 * <p>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <p>
 * <p>
 * Created by sunilpatil on 11/30/16.
 */
public class Problem189 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k > length)
            k = k - length;
        int[] tmp = new int[k];
        int c = 0;
        for (int i = length - k; i < length; i++) {
            tmp[c++] = nums[i];
        }
        c = length - 1;
        while (c >= k) {
            nums[c] = nums[c - k];
            c--;
        }
        for (int i = 0; i < tmp.length; i++) {
            nums[i] = tmp[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            moveLastElement(nums);
        }
    }

    private void moveLastElement(int[] nums) {
        int length = nums.length;
        int t = nums[length - 1];
        int c = length - 1;
        while (c > 0) {
            nums[c] = nums[c - 1];
            c--;
        }
        nums[0] = t;
    }
}
