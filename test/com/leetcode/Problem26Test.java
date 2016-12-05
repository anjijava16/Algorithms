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
        assert a[0] == 1;
        assert a[1] == 2;

    }

    @Test
    public void testSimple2() {
        int[] a = new int[]{1, 1, 2, 3};
        assert problem.removeDuplicates(a) == 3;
        assert a[0] == 1;
//        assert a[1] == 2;
        //       assert a[2] == 3;

    }

    @Test
    public void testSimple3() {
        int[] a = new int[]{1, 1};
        assert problem.removeDuplicates(a) == 1;
        assert a[0] == 1;
//        assert a[1] == 2;
        //       assert a[2] == 3;

    }

    @Test
    public void testSimple4() {
        int[] a = new int[]{1, 2};
        assert problem.removeDuplicates(a) == 2;
        assert a[0] == 1;
    }

    @Test
    public void testSimple5() {
        int[] a = new int[]{1};
        assert problem.removeDuplicates(a) == 1;
        assert a[0] == 1;
    }
}
