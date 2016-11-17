package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/13/16.
 */
public class Problem7Test {
    Problem7 problem;

    @Before
    public void setup() {
        problem = new Problem7();
    }

    @Test
    public void test() {
        assert problem.reverse2(123) == 321;

    }

    @Test
    public void testNegative() {
        assert problem.reverse2(-123) == -321;
    }

    @Test
    public void test2() {

        assert problem.reverse2(1534236469) == 0;

    }

    @Test
    public void test3() {

        assert problem.reverse2(-2147483648) == 0;

    }
}
