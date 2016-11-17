package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sunilpatil on 11/12/16.
 */
public class Problem167Test {

    Problem167 problem;

    @Before
    public void setup() {
        problem = new Problem167();
    }

    @Test
    public void testBinarySearch() {
        assert problem.binarySearchRecursive(new int[]{1, 2, 3, 4, 5}, 0, 5, 3) == 2;
        assert problem.binarySearchRecursive(new int[]{1, 2, 3, 4, 5}, 0, 5, 0) == -1;
        assert problem.binarySearchRecursive(new int[]{1, 2, 3, 4, 5}, 0, 5, 7) == -1;
    }

    @Test
    public void testSimple() {
        int[] a = new int[]{2, 3, 4};
        int[] o = problem.twoSum(a, 6);
        System.out.println(Arrays.toString(o));
        assert o != null;
        assert o[0] == 1;
        assert o[1] == 3;

    }

    @Test
    public void testSum() {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] sumParis = problem.twoSum(a, 8);
        assert sumParis != null;
        assert sumParis[0] == 3;
        assert sumParis[1] == 5;
        System.out.println(Arrays.toString(sumParis));
    }

    @Test
    public void testSum1() {
        int[] a = new int[]{3, 2, 4};
        int[] sumParis = problem.twoSum(a, 6);
        assert sumParis != null;
        assert sumParis[0] == 1;
        assert sumParis[1] == 2;

        System.out.println(Arrays.toString(sumParis));
    }

    @Test
    public void testSum3() {
        int[] a = new int[]{0, 0, 3, 4};
        int[] sumParis = problem.twoSum(a, 0);
        assert sumParis != null;
        assert sumParis[0] == 1;
        assert sumParis[1] == 2;

        System.out.println(Arrays.toString(sumParis));
    }
}
