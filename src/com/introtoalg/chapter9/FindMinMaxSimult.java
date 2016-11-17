package com.introtoalg.chapter9;

/**
 * Created by sunilpatil on 11/15/16.
 */
public class FindMinMaxSimult {


    public int comparisions = 0;

    public int[] findMinMax(int[] a) {
        int[] r = new int[2];

        int min = a[0];
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], min))
                min = a[i];
            if (less(max, a[i]))
                max = a[i];
        }
        r[0] = min;
        r[1] = max;
        return r;
    }

    public int[] findMinMax2(int[] a) {
        int[] r = new int[2];

        int min = a[0];
        int max = a[0];
        for (int i = 1; i < a.length; i = i + 2) {
            int first = a[i];
            int second = 0;
            if (i + 1 < a.length)
                second = a[i + 1];
            else
                second = a[i];
            if (less(first, second)) {
                // First element is less than second
                if (less(first, min)) {
                    min = first;
                }
                if (less(max, second)) {
                    max = second;
                }
            } else {
                //Second element is less than first
                if (less(second, min)) {
                    min = second;
                }
                if (less(max, first)) {
                    max = first;
                }
            }
            if (Math.min(min, a[i]) != min)
                min = a[i];
            if (Math.max(max, a[i]) != max)
                max = a[i];
        }
        r[0] = min;
        r[1] = max;
        return r;
    }

    private boolean less(int a, int b) {
        comparisions = comparisions + 1;
        if (a < b)
            return true;
        else
            return false;
    }
}
