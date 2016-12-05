package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5,
 * Return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * Created by sunilpatil on 12/2/16.
 */
public class Problem118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        if (numRows == 0)
            return pascalTriangle;
        List<Integer> previousRow = new ArrayList<>();
        List<Integer> currentRow = null;
        pascalTriangle.add(previousRow);
        previousRow.add(1);
        for (int i = 2; i <= numRows; i++) {
            currentRow = new ArrayList<>();
            currentRow.add(1);
            for (int j = 0; j <= i - 3; j++) {
                int sum = previousRow.get(j) + previousRow.get(j + 1);
                currentRow.add(sum);
            }
            currentRow.add(1);
            pascalTriangle.add(currentRow);
            previousRow = currentRow;
        }
        return pascalTriangle;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>(i);
            if (i % 2 == 0) {
                for (int j = 0; j <= i / 2; j++) {
                    rowList.add(pascal(i, j));
                }
                int rowLength = rowList.size() - 2;
                for (int k = rowLength; k >= 0; k--)
                    rowList.add(rowList.get(k));
            } else {
                for (int j = 0; j <= i / 2; j++) {
                    rowList.add(pascal(i, j));
                }
                int rowLength = rowList.size() - 1;
                for (int k = rowLength; k >= 0; k--)
                    rowList.add(rowList.get(k));
            }

            pascalTriangle.add(rowList);
        }
        return pascalTriangle;
    }

    private int pascal(int i, int j) {
        if (j == 0 || j == i)
            return 1;
        else
            return pascal(i - 1, j - 1) + pascal(i - 1, j);
    }

    public void printPascalTriangle(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("Row Number " + i + " -> ");
            if (i % 2 == 0) {
                for (int j = 0; j <= i / 2; j++) {
                    System.out.print(pascal(i, j) + " ");
                }
            } else {
                for (int j = 0; j <= i / 2; j++) {
                    System.out.print(pascal(i, j) + " ");
                }
            }
            System.out.println();
        }
    }


}
