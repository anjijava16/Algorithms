package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 12/10/16.
 */
public class Problem191Test {
    Problem191 problem;

    @Before
    public void setup() {
        problem = new Problem191();
    }

    @Test
    public void testSimple() {
        assert problem.hammingWeight(11) == 3;
    }

    @Test
    public void testLongNumber() {
        System.out.println(problem.hammingWeight(Integer.MIN_VALUE));
        assert problem.hammingWeight(Integer.MIN_VALUE) == 32;
    }
}
