package com.algo4.chapter1.section1.exercise;

import java.util.Arrays;

/**
 * Created by sunilpatil on 8/24/16.
 */
public class Util {

    public static double sqrt (double c){
        double err = 1e-15;
        if( c< 0)
            return Double.NaN;
        double t = c;
        while( Math.abs( t - c/t) > err*t)
            t = (c/t +t) /2.0;
        return t;
    }

    public static boolean isPrime(int N){
        if( N <2) return false;
        for( int i= 2; i*i <=N ; i++){
            if( N % i == 0)
                return false;
        }
        return true;
    }

    public static void reverse(int[] a){
        int hi = a.length -1;
        int lo = 0;
        while(hi >= lo){
            int temp = a[hi];
            a[hi] = a[lo];
            a[lo] = temp;
            hi --;
            lo++;
        }
    }

    public static double hypotenuse(double a, double b){
        return Math.sqrt( a*a + b*b);
    }

    public static double harmonic(int N){
        double sum = 0.0;
        for( int i = 1 ; i < N; i++)
            sum += 1.0/i;
        return sum;
    }

    public static void main(String[] argv){
      //  System.out.println(harmonic(13));
     //   System.out.println(isPrime(5));

        int[] input = new int[] {1,2,3,4,5};

        System.out.println(Arrays.toString(input));
        reverse(input);
        System.out.println(Arrays.toString(input));

    }
}
