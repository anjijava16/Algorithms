package com.algo4.chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by sunilpatil on 9/17/16.
 */
public class Example {

    public static void sort(Comparable[] a){
        Arrays.sort(a);
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for(int i =0 ; i < a.length;i++)
            StdOut.print(a[i] +" ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        for(int i =1; i < a.length;i++ )
            if(less(a[i], a[i-1]))
                return false;
        return true;
    }

    public static void main(String[] argv){
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
