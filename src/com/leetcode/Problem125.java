package com.leetcode;

/**
 * 125. Valid Palindrome
 * Created by sunilpatil on 11/30/16.
 */
public class Problem125 {
    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        char[] c = s.toCharArray();
        int start = 0;
        int end = c.length - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(c[start])) {
                start = start + 1;
                continue;
            } else if (!Character.isLetterOrDigit(c[end])) {
                end = end - 1;
                continue;
            }
            //   char startChar = Character.toLowerCase(c[start]);
            //   char endChar = Character.toLowerCase(c[end]);
            //   System.out.println("Compare characters -> " + startChar + " endChar -> " + endChar);
            if (Character.toLowerCase(c[start]) != Character.toLowerCase(c[end]))
                return false;
            start = start + 1;
            end = end - 1;
        }
        return true;
    }
}
