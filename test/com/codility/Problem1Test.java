package com.codility;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/6/16.
 */
public class Problem1Test {
    Problem1 problem1;

    @Before
    public void setup() {
        problem1 = new Problem1();
    }

    @Test
    public void testNormal() {
        assert problem1.solution(5, new int[]{5, 5, 1, 7, 2, 3, 5}) == 4;
    }

    @Test
    public void testNoMatching() {
        assert problem1.solution(5, new int[]{1, 2, 3, 4}) == 4;
    }

    @Test
    public void testAllMatching() {
        assert problem1.solution(5, new int[]{5, 5, 5, 5}) == 0;
    }
}
