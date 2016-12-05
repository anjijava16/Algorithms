package com.leetcode.contest2;

import org.junit.Test;

/**
 * Created by sunilpatil on 12/3/16.
 */
public class Problem434Test {

    @Test
    public void testEmptyString() {
        Problem434 problem434 = new Problem434();
        assert problem434.countSegments("") == 0;

    }

    @Test
    public void testSimple() {
        Problem434 problem434 = new Problem434();
        assert problem434.countSegments("Hello, my name is John") == 5;
    }

    @Test
    public void testLongEmptyString() {
        Problem434 problem434 = new Problem434();
        System.out.println("                ".trim().length());
        assert problem434.countSegments("                ") == 0;
    }

}
