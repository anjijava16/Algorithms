package com.algo4.chapter2;

import edu.princeton.cs.algs4.Selection;

import java.util.Arrays;

/**
 * Created by sunilpatil on 9/17/16.
 */
public class SelectionSort {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {

            int lowest = i;
            for (int j = i+1; j < a.length; j++) {
                if(less(lowest, j))
                    lowest =j;
            }
            exch(a,i,lowest);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] argv){
        String[] strings = new String[]{"First","Second","Third","Fourth"};
        System.out.println(Arrays.toString(strings));
        Selection.sort(strings);
        System.out.println(Arrays.toString(strings));
    }

}
