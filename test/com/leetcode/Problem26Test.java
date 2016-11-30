package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/30/16.
 */
public class Problem26Test {
    Problem26 problem;

    @Before
    public void setup() {
        problem = new Problem26();
    }

    @Test
    public void testSimple() {
        int[] a = new int[]{1, 1, 2};
        assert problem.removeDuplicates(a) == 2;
    }
}
