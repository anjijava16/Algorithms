package com.leetcode;

import com.clrs.HelloBitManipulation;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 12/10/16.
 */
public class Problem231Test {

    Problem231 problem;

    @Before
    public void setup() {
        problem = new Problem231();
    }

    @Test
    public void testSimple() {
        assert problem.isPowerOfTwo(2);
        assert problem.isPowerOfTwo(16);
        assert problem.isPowerOfTwo(64);

        assert !problem.isPowerOfTwo(6);

        assert !problem.isPowerOfTwo(30);
        assert !problem.isPowerOfTwo(65);
    }

    @Test
    public void testNegativeNumber() {
        HelloBitManipulation hbm = new HelloBitManipulation();
        System.out.println(hbm.convertDecimalToBinary(-2147483648));
        assert !problem.isPowerOfTwo(-2147483648);

    }

    @Test
    public void testBinaryOperation() {

        int x = 14;
        HelloBitManipulation hbm = new HelloBitManipulation();
        System.out.println(hbm.convertDecimalToBinary(x));
        System.out.println(x & 1);
        x = x >>> 1;
        System.out.println(hbm.convertDecimalToBinary(x));
        x = x >>> 1;
        System.out.println(hbm.convertDecimalToBinary(x));
        x = x >>> 1;
        System.out.println(hbm.convertDecimalToBinary(x));
    }
}
