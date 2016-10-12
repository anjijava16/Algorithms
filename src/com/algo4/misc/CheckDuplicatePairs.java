package com.algo4.misc;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by sunilpatil on 10/12/16.
 */
public class CheckDuplicatePairs {
    public static void main(String[] argv) {
        CheckDuplicatePairs checkDuplicatePairs = new CheckDuplicatePairs();
        checkDuplicatePairs.checkDuplicatePairs(new int[][]{{1, 2}, {2, 3}, {3, 2}, {1, 4}});
    }

    public void checkDuplicatePairs(int[][] pairs) {
        HashMap<Integer, Integer> pairKeys = new HashMap<>();

        for (int[] pair : pairs) {
            int key = pair[0];
            int value = pair[1];
            if (pairKeys.containsKey(key)) {
                if (pairKeys.get(key).equals(value)) {
                    System.out.println("Found duplicate, in same order " + Arrays.toString(pair));
                }
            } else if (pairKeys.containsKey(value)) {
                if (pairKeys.get(value).equals(key)) {
                    System.out.println("Found duplicate, in reverse order " + Arrays.toString(pair));
                }
            } else {
                pairKeys.put(key, value);
            }
        }
    }
}
