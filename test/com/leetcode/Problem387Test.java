package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/27/16.
 */
public class Problem387Test {
    Problem387 problem;

    @Before
    public void setup() {
        problem = new Problem387();
    }

    @Test
    public void testSimple() {
        assert problem.firstUniqChar("leetcode") == 0;
    }

    @Test
    public void testSimple2() {
        assert problem.firstUniqChar("loveleetcode") == 2;
    }
}
