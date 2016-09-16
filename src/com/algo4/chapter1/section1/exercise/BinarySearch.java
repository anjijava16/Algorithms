package com.algo4.chapter1.section1.exercise;

import java.util.Arrays;

/**
 * Created by sunilpatil on 8/24/16.
 */
public class BinarySearch {

    public static int binarySearch(int key, int[] a) {
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

    public static int binarySearch1(int key, int[] a){
        return binarySearchRecursive(key, a, 0, a.length-1);
    }
    public static int binarySearchRecursive(int key, int[] a, int low, int high){
        if(low > high)
            return -1;
        int mid = low + (high -low)/2;
        if(key < a[mid])
            return binarySearchRecursive(key,a,low, mid-1 );
        else if(key > a[mid])
            return binarySearchRecursive(key, a, mid+1, high);
        else
            return mid;
    }

    public static void main(String[] argv) {
        int[] whitelist = {10, 2, 5, 12, 16, 8, 7};
        Arrays.sort(whitelist);
        System.out.println(Arrays.toString(whitelist));

        System.out.println(binarySearch1(10, whitelist));

        int a =0, b =0, c= 0;
    }


}
