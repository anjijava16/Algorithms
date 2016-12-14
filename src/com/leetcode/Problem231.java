package com.leetcode;

/**
 * Created by sunilpatil on 12/10/16.
 */
public class Problem231 {
    public boolean isPowerOfTwo(int n) {
        if (n < 0)
            return false;
        int c = n;
        int noOfOnes = 0;
        while (c != 0) {
            int flag = c & 1;
            if (flag == 1)
                noOfOnes++;
            c = c >>> 1;
        }
        if (noOfOnes == 1)
            return true;
        return false;
    }
}
