package com.leetcode;

import java.util.Arrays;

/**
 * 389. Find the Difference
 * Given two strings s and t which consist of only lowercase letters.
 * <p>
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * <p>
 * Find the letter that was added in t.
 * <p>
 * Example:
 * <p>
 * Input:
 * s = "abcd"
 * t = "abcde"
 * <p>
 * Output:
 * e
 * <p>
 * Explanation:
 * 'e' is the letter that was added.
 * Created by sunilpatil on 12/4/16.
 */
public class Problem389 {
    public char findTheDifference(String s, String t) {
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        Arrays.sort(first);

        Arrays.sort(second);
        for (int i = 0; i < second.length; i++) {
            if (i > first.length - 1)
                return second[i];
            if (first[i] != second[i])
                return second[i];

        }
        return '0';
    }
}
