package com.coursera.ada1.week3;

/**
 * Created by sunilpatil on 11/14/16.
 */
public class RandomSelection {


    public int randomizedSelect(int[] a, int t) {
        return randomizedSelect(a, 0, a.length - 1, t);
    }

    public int randomizedSelect(int[] a, int p, int r, int i) {
        if (a[p] == a[r])
            return a[p];
        int q = partition(a, p, r);
        int k = q - p + 1;
        if (i == k)
            return a[q];
        else if (i < k)
            return randomizedSelect(a, p, q - 1, i);
        else
            return randomizedSelect(a, q + 1, r, i - k);
    }

    private int partition(int[] a, int l, int r) {
        int p = a[l];
        int i = l + 1;
        for (int j = l + 1; j <= r; j++) {
            if (less(a[j], p)) {
                //i++;
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i - 1, l);
        return i - 1;
    }

    private boolean less(int i, int j) {
        if (i <= j)
            return true;
        else
            return false;
    }

    private void swap(int[] a, int f, int s) {
        int temp = a[f];
        a[f] = a[s];
        a[s] = temp;
    }
}
