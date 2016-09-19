package com.algo4.chapter2;

import edu.princeton.cs.algs4.Selection;

import java.util.Arrays;

/**
 * Created by sunilpatil on 9/18/16.
 */
public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;

        int h =1;
        while( h < N/3)
            h = 3*h +1;
        while(h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j > h; j = j-h) {
                    if (less(a[j], a[j - h]))
                        exch(a, j, j - h);
                    else
                        break;
                }
            }
            h = h/3;
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
