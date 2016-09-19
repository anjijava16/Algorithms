package com.algo4.chapter2;

import edu.princeton.cs.algs4.Selection;

import java.util.Arrays;

/**
 * Created by sunilpatil on 9/17/16.
 */
public class InsertionSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);
                else
                    break;
            }
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

    public static void main(String[] argv) {
        String[] strings = new String[]{"First", "Second", "Third", "Fourth", "Fifth", "Sixth",
                "Seventh", "Eigth", "Ninth", "Tenth"};
        System.out.println(Arrays.toString(strings));
        Selection.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
