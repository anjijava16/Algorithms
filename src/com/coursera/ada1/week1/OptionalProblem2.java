package com.coursera.ada1.week1;

/**
 * Created by sunilpatil on 11/9/16.
 * You are a given a unimodal array of n distinct elements, meaning that its entries are in increasing order up until its maximum element, after which its elements are in decreasing order.
 * Give an algorithm to compute the maximum element that runs in O(log n) time.
 */
public class OptionalProblem2 {

    public int findMod(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1])
                return i;
        }
        return -1;
    }

    public int findModRecursive(int[] a) {
        return findModRecursive(a, 0, a.length);
    }

    private int findModRecursive(int[] a, int hi, int lo) {
        int mid = lo + ((hi - lo) / 2);
        //  if()
        return 0;
    }

    private int binarySearch(int[] a, int t) {
        int lo = 0;
        int hi = a.length;
        while (lo < hi) {
            int mid = lo + ((hi - lo) / 2);
            if (a[mid] == t)
                return mid;
            else if (t < a[mid]) {
                hi = mid - 1;
            } else if (t > a[mid]) {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
