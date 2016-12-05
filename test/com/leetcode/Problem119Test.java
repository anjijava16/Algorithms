package com.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by sunilpatil on 12/2/16.
 */
public class Problem119Test {
    Problem119 problem;

    @Before
    public void setup() {
        problem = new Problem119();
    }

    @Test
    public void testZeroRow() {
        List<Integer> rowList = problem.getRow(0);
        assert rowList.size() == 1;
        assert rowList.get(0) == 1;
    }

    @Test
    public void testOneRow() {
        List<Integer> rowList = problem.getRow(1);
        assert rowList.size() == 2;
        assert rowList.get(0) == 1;
        assert rowList.get(1) == 1;
    }

    @Test
    public void testThreeRows() {
        List<Integer> rowList = problem.getRow(3);
        System.out.println(rowList);
        assert rowList.size() == 4;
        assert rowList.get(0) == 1;
        assert rowList.get(1) == 3;
        assert rowList.get(2) == 3;
        assert rowList.get(3) == 1;
    }

    @Test
    public void testFifthRow() {
        List<Integer> rowList = problem.getRow(5);
        System.out.println(rowList);
        assert rowList.get(0) == 1;
        assert rowList.get(1) == 4;
        assert rowList.get(2) == 6;
        assert rowList.get(3) == 4;
        assert rowList.get(4) == 1;
    }

    @Test
    public void testSimple2() {
        long startTime = System.currentTimeMillis();
        List<Integer> rowList = problem.getRow(26);
        System.out.println(rowList);
        System.out.println(System.currentTimeMillis() - startTime);
        assert rowList.size() == 26;
        assert rowList.get(0) == 1;

        assert rowList.get(26) == 1;
    }
}
