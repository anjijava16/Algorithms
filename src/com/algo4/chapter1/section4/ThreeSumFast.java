package com.algo4.chapter1.section4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * Created by sunilpatil on 9/4/16.
 */
public class ThreeSumFast {
    public static void main(String[] argv){
        int[] a = In.readInts(argv[0]);
        System.out.println(count(a));
    }

    public static int count(int[] a){
        int N = a.length;
        int count = 0;
        Arrays.sort(a);
        for(int i = 0 ; i < N; i++){
            for(int j = i+1 ; j < N ; j++){
                int sum = a[i] + a[j];
                if(BinarySearch.indexOf(a,-sum) > j)
                    count++;
            }
        }
        return count;
    }
}
