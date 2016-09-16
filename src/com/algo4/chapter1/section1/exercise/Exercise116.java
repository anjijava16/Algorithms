package com.algo4.chapter1.section1.exercise;

/**
 * Created by sunilpatil on 8/29/16.
 */
public class Exercise116 {

    public static void main(String[] argv){

        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++)
        {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
        int N = 10;
        String s = "";
        for (int n = N; n > 0; n /= 2)
            s = (n % 2) + s;
        System.out.println(s);
    }
}
