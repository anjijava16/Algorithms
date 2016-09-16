package com.algo4.chapter1.section1.exercise;

/**
 * Created by sunilpatil on 8/29/16.
 */
public class Fibonacci {

    private static long[] fibValues = new long[100];

    public static long F(int N){
        if(fibValues[N] !=-1)
            return fibValues[N];
        if(N == 0)
            return 0;
        if(N ==1)
            return 1;
        return F(N-1)+F(N-2);
    }

    public static void main(String[] argv){

        for(int i =0 ;i < fibValues.length;i++)
            fibValues[i] = -1;

        for(int N = 0; N < 100 ; N++) {
            long value = F(N);
            fibValues[N] = value;
            System.out.println(N + " -> " + F(N));
            Math.log(1);
        }
    }
}
