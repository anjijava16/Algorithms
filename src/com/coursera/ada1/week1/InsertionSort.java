package com.coursera.ada1.week1;

/**
 * Created by sunilpatil on 11/5/16.
 */
public class InsertionSort {
    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int k = i;
            while (k >= 1 && a[k] < a[k - 1]) {
                exch(a, k, k - 1);
                k--;
            }
        }
    }

    public void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
