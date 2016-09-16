package com.algo4.chapter1.section1.exercise;

/**
 * Created by sunilpatil on 8/31/16.
 */
public class Exercise1129 {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static int count(int key, int[] a){
        return 0;
    }

    public static void main(String[] argv){

    }
}
