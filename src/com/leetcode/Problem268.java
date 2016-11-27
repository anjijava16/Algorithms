package com.leetcode;

import java.util.Arrays;

/**
 * Created by sunilpatil on 11/26/16.
 */
public class Problem268 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i])
                return i;
        }
        return nums[nums.length - 1] + 1;
    }
}
