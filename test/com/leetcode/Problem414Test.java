package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/29/16.
 */
public class Problem414Test {
    Problem414 problem;

    @Before
    public void setup() {
        problem = new Problem414();
    }

    @Test
    public void testSimple() {
        int[] a = new int[]{3, 2, 1};
        assert problem.thirdMax(a) == 1;
    }

    @Test
    public void testSimpl2() {
        int[] a = new int[]{1, 2};
        assert problem.thirdMax(a) == 2;
    }

    @Test
    public void testSimpl1() {
        int[] a = new int[]{2, 2, 3, 1};
        assert problem.thirdMax(a) == 1;
    }

    @Test
    public void testSimpl3() {
        int[] a = new int[]{5, 2, 4, 1, 3, 6, 0};
        assert problem.thirdMax(a) == 4;
    }
}
