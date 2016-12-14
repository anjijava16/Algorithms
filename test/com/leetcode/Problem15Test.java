package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunilpatil on 12/5/16.
 */
public class Problem15Test {
    Problem15 problem;

    @Before
    public void setup() {
        problem = new Problem15();
    }

    @Test
    public void test5Elements() {
        int[] a = new int[]{-1, 0, 1, 2, -1, -4};
        List sumList = problem.threeSum(a);
        assert sumList.size() == 2;

    }

    @Test
    public void test1Elements() {
        int[] a = new int[]{-1};
        List sumList = problem.threeSum(a);
        assert sumList.size() == 0;

    }

    @Test
    public void testBigList() {
        int[] a = new int[]{-4, -5, -6, 3, 11, -13, 3, 14, 1, -10, 11, 6, 8, 9, -6, -9, 6, 3, -15, -8, 0, 5, 6, -8, 14, -11, 0, 2, 14, -15, 14, -13, -5, -15, 5, 13, -13, -6, 13, -4, -1, 1, -13, 14, -13, -12, -10, 9, 6, 12, 8, 14, -5, -8, -9, -6, -4, -2, 3, -5, -2, -6, -2, 1, -5, -12, -1, -11, -11, -11, 0, -4, -2, -5, -5, 0, -2, -7, -14, -10, -10, 10, -11, -8, -13, -13, 1, -2, -7, 11, 8, 6, -9, -9, 14, 1, -13, -9, -3, -9, -5, 13, 2, 8, -7, 13, -14, 6, -9, -13, 3, -12};
        List sumList = problem.threeSum(a);
        //assert sumList.size() == 0;

    }

    @Test
    public void testMediumList() {
        int[] a = new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        List sumList = problem.threeSum(a);
        assert sumList.size() == 6;

    }


}
