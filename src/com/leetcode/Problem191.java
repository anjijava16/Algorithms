package com.leetcode;

/**
 * Created by sunilpatil on 12/10/16.
 */
public class Problem191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        long c = n;
        int noOfOnes = 0;
        while (c != 0) {
            long flag = c & 1;
            if (flag == 1)
                noOfOnes++;
            c = c >>> 1;
        }
        if (n < 0)
            return noOfOnes - 1;
        return noOfOnes;
    }
}
