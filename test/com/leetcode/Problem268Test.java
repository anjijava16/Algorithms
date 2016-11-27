package com.leetcode;

import org.junit.Test;

/**
 * Created by sunilpatil on 11/26/16.
 */
public class Problem268Test {
    Problem268 problem268 = new Problem268();

    @Test
    public void testSimple() {
        int[] nums = new int[]{0, 3, 1};
        assert problem268.missingNumber(nums) == 2;
    }

    @Test
    public void testSingleELement() {
        int[] nums = new int[]{0};
        assert problem268.missingNumber(nums) == 1;
    }

    @Test
    public void testTwoELements() {
        int[] nums = new int[]{0, 1};
        assert problem268.missingNumber(nums) == 2;
    }

    @Test
    public void testWithoutZero() {
        int[] nums = new int[]{1};
        assert problem268.missingNumber(nums) == 0;
    }

    @Test
    public void testWithoutZero2() {
        int[] nums = new int[]{1, 0};
        assert problem268.missingNumber(nums) == 2;
    }
}
