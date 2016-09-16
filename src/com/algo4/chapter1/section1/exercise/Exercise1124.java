package com.algo4.chapter1.section1.exercise;

/**
 * Created by sunilpatil on 8/29/16.
 */
public class Exercise1124 {
    public static void main(String[] argv) {
        System.out.println(gcd(1234567,1111111));
    }

    public static int gcd(int p, int q) {
        System.out.println("p-> " + p +", q->"+q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }
}
