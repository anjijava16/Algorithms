package com.leetcode;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class Problem118Test {
    Problem118 problem;

    @Before
    public void setup() {
        problem = new Problem118();
    }

    @Test
    public void testPrintPascal() {
        problem.printPascalTriangle(5);
    }

    @Test
    public void testZeroRows() {
        List<List<Integer>> triangle = problem.generate(0);
        assert triangle.size() == 0;

    }

    @Test
    public void testGeneratePascal() {
        List<List<Integer>> triangle = problem.generate(5);
        int rowCounter = 0;
        for (List<Integer> row : triangle) {
            System.out.print("Row " + rowCounter++ + " -> ");
            for (Integer i : row)
                System.out.print(i + " ");
            System.out.println();
        }
        assert triangle.size() == 5;
        assert triangle.get(0).get(0) == 1;

        assert triangle.get(2).get(1) == 2;
    }

}
