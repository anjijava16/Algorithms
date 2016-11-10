package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sunilpatil on 11/9/16.
 */
public class Problem1Test {
    Problem1 problem1;

    @Before
    public void setup() {
        problem1 = new Problem1();
    }

    @Test
    public void testBinarySearch() {
        assert problem1.binarySearch(new int[]{1, 2, 3, 4, 5}, 3) == 2;
        assert problem1.binarySearch(new int[]{1, 2, 3, 4, 5}, 0) == -1;
        assert problem1.binarySearch(new int[]{1, 2, 3, 4, 5}, 7) == -1;
    }

    @Test
    public void testSum() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] sumParis = problem1.twoSum(a, 8);

        System.out.println(Arrays.toString(sumParis));
    }

    @Test
    public void testSum1() {
        int[] a = new int[]{0, 4, 3, 0};
        int[] sumParis = problem1.twoSum(a, 8);

        System.out.println(Arrays.toString(sumParis));

    }
}
