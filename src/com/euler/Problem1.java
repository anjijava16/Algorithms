package com.euler;

import java.util.Scanner;

/**
 * Created by sunilpatil on 11/8/16.
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            long count = getSum(n);
            System.out.println(count);
        }
    }

    public static long getSum(long n) {
        long returnValue = 0;
        for (int i = 3; i < n; i = i + 3) {
            returnValue = returnValue + i;
        }
        for (int i = 5; i < n; i = i + 5) {
            returnValue = returnValue + i;
        }
        for (int i = 15; i < n; i = i + 15) {
            returnValue = returnValue - i;
        }
        return returnValue;
    }
}
