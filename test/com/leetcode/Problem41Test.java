package com.leetcode;

import org.junit.Test;

/**
 * Created by sunilpatil on 11/26/16.
 */
public class Problem41Test {
    Problem41 problem = new Problem41();

    @Test
    public void testSimple() {
        int[] nums = new int[]{0, 3, 1};
        assert problem.firstMissingPositive(nums) == 2;
    }

    @Test
    public void testSimple2() {
        int[] nums = new int[]{1, 2, 0};
        assert problem.firstMissingPositive(nums) == 3;
    }

    @Test
    public void testSimple3() {
        int[] nums = new int[]{3, 4, -1, 1};
        assert problem.firstMissingPositive(nums) == 3;
    }
}
