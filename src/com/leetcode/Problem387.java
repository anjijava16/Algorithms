package com.leetcode;

/**
 * First Unique Character in a String
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class Problem387 {

    public int firstUniqChar(String s) {
        int[] charFrequency = new int[256];
        for (int i = 0; i < charFrequency.length; i++)
            charFrequency[i] = 0;
        char[] chars = s.toCharArray();
        for (char c : chars)
            System.out.println((int) c);
        return 0;
    }
}