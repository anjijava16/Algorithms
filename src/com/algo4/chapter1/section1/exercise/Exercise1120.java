package com.algo4.chapter1.section1.exercise;

/**
 * Created by sunilpatil on 8/29/16.
 */
public class Exercise1120 {

    public static void main(String[] argv) {
        for (int i = 0; i < 10; i++)
            System.out.println(i + "->" + factorial(i));

        System.out.println(Math.log(factorial(10)));
    }

    public static int factorial(int n) {
        if (n < 2)
            return 1;
        return n * factorial(n - 1);
    }
}
