package com.coursera.ada1.week1;

/**
 * Created by sunilpatil on 11/5/16.
 */
public class BaseSortTest {
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1].compareTo(a[i]) > 0)
                return false;
        }
        return true;
    }

    public boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i])
                return false;
        }
        return true;
    }
}
