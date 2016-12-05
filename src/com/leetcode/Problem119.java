package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilpatil on 12/2/16.
 */
public class Problem119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> previousRow = new ArrayList<>();

        previousRow.add(1);
        if (rowIndex == 0)
            return previousRow;

        List<Integer> currentRow = null;
        for (int i = 2; i <= rowIndex + 1; i++) {
            currentRow = new ArrayList<>();
            currentRow.add(1);
            for (int j = 0; j <= i - 3; j++) {
                int sum = previousRow.get(j) + previousRow.get(j + 1);
                currentRow.add(sum);
            }
            currentRow.add(1);
            previousRow = currentRow;
        }
        return currentRow;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> integerList = new ArrayList<>(rowIndex);
        //If rowIndex is even
        if (rowIndex % 2 == 0) {
            for (int j = 0; j <= rowIndex / 2; j++) {
                integerList.add(pascal(rowIndex, j));
            }
            int rowLength = integerList.size() - 2;
            for (int k = rowLength; k >= 0; k--)
                integerList.add(integerList.get(k));
        } else {
            for (int j = 0; j <= rowIndex / 2; j++) {
                integerList.add(pascal(rowIndex, j));
            }
            int rowLength = integerList.size() - 1;
            for (int k = rowLength; k >= 0; k--)
                integerList.add(integerList.get(k));
        }

        return integerList;
    }

    private int pascal(int i, int j) {
        if (j == 0 || j == i)
            return 1;
        else
            return pascal(i - 1, j - 1) + pascal(i - 1, j);
    }
}
