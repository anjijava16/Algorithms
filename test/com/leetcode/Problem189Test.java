package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sunilpatil on 11/30/16.
 */
public class Problem189Test {
    Problem189 problem;

    @Before
    public void setup() {
        problem = new Problem189();
    }

    @Test
    public void testMove3Element() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        problem.rotate(a, 3);
        assert Arrays.equals(a, new int[]{5, 6, 7, 1, 2, 3, 4});
    }

    @Test
    public void testMove1Element() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        problem.rotate(a, 1);
        assert Arrays.equals(a, new int[]{7, 1, 2, 3, 4, 5, 6});
    }

    @Test
    public void testMove2Element() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        problem.rotate(a, 2);
        assert Arrays.equals(a, new int[]{6, 7, 1, 2, 3, 4, 5});
    }

    @Test
    public void testMoveMoreThanArrayLength() {
        int[] a = new int[]{1, 2};
        problem.rotate(a, 3);
        assert Arrays.equals(a, new int[]{2, 1});
    }
}
