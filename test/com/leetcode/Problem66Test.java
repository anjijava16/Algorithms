package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 12/21/16.
 */
public class Problem66Test {
    Problem66 problem;

    @Before
    public void setup() {
        problem = new Problem66();
    }

    @Test
    public void testSimple3() {
        int[] i = new int[]{1, 3, 4};
        int[] o = problem.plusOne(i);

        assert o.length == 3;
        assert o[0] == 1;
        assert o[1] == 3;
        assert o[2] == 5;
    }

    @Test
    public void testSimple() {
        int[] i = new int[]{1, 2, 9};
        int[] o = problem.plusOne(i);

        assert o.length == 3;
        assert o[0] == 1;
        assert o[1] == 3;
        assert o[2] == 0;
    }

    @Test
    public void testSimple2() {
        int[] i = new int[]{9, 9, 9};
        int[] o = problem.plusOne(i);

        assert o.length == 4;
        assert o[0] == 1;
        assert o[1] == 0;
        assert o[2] == 0;
        assert o[3] == 0;
    }
}
