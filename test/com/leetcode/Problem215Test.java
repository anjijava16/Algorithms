package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/29/16.
 */
public class Problem215Test {
    Problem215 problem;

    @Before
    public void setup() {
        problem = new Problem215();
    }

    @Test
    public void testSimple() {
        int[] test = new int[]{3, 2, 1, 5, 6, 4};
        assert problem.findKthLargest(test, 2) == 5;
    }
}
