package com.euler;

/**
 * Created by sunilpatil on 11/8/16.
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1 {

    public static void main(String[] argv) {
        Problem1 problem1 = new Problem1();
        System.out.println("Sum of 10 " + problem1.getSum(10));
        System.out.println("Sum of 1000 " + problem1.getSum(1000));

    }

    public long getSum(int n) {
        long returnValue = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                returnValue = returnValue + i;
        }
        return returnValue;
    }
}
