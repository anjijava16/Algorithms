package com.coursera.ada1.week1;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/9/16.
 */
public class OptionalProblem2Test {
    OptionalProblem2 optionalProblem2;

    @Before
    public void setup() {
        optionalProblem2 = new OptionalProblem2();
    }

    @Test
    public void testSimple() {
        int[] a = new int[]{1, 3, 5, 2, 4};
        assert optionalProblem2.findModRecursive(a) == 3;
    }

    @Test
    public void testInvalid() {
        int[] a = new int[]{1, 3, 5, 6, 7};
        assert optionalProblem2.findModRecursive(a) == -1;
    }

    @Test
    public void testReverse() {
        int[] a = new int[]{7, 6, 5, 4, 3};
        assert optionalProblem2.findModRecursive(a) == 1;
    }

}
