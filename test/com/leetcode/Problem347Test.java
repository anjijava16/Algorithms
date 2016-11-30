package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunilpatil on 11/29/16.
 */
public class Problem347Test {
    Problem347 problem;

    @Before
    public void setup() {
        problem = new Problem347();
    }

    @Test
    public void testSimple() {
        int[] a = new int[]{1, 1, 1, 2, 2, 3};
        List<Integer> kElement = problem.topKFrequent(a, 2);

        assert kElement.size() == 2;
        assert kElement.get(0) == 1;
        assert kElement.get(1) == 2;
    }
}
