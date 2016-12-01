package com.leetcode;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/30/16.
 */
public class Problem125Test {
    Problem125 problem;

    @Before
    public void setup() {
        problem = new Problem125();
    }

    @Test
    public void testSimple() {
        assert problem.isPalindrome("aabbccbbaa") == true;
    }

    @Test
    public void testComplexString() {
        assert problem.isPalindrome("A man, a plan, a canal: Panama") == true;
    }

    @Test
    public void testForNegativeTest() {
        assert problem.isPalindrome("race a car") == false;
    }

    @Test
    public void testEmptyString() {
        assert problem.isPalindrome("") == true;
    }
}
