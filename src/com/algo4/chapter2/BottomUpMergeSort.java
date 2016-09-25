package com.algo4.chapter2;

import java.util.Arrays;

/**
 * Created by sunilpatil on 9/20/16.
 */
public class BottomUpMergeSort {
    private static Comparable[] aux;
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i =lo, j = mid+1;
        for(int k = lo ; k <= hi ;k++)
            aux[k] = a[k];

        for(int k = lo; k <= hi ; k++){
            if(i >mid)
                a[k] = aux[j++];
            else if(j > hi)
                a[k] = aux[i++];
            else {
                if(less(aux[i], aux[j])){
                    a[k] = aux[i++];
                }else{
                    a[k] = aux[j++];

                }
            }
        }
    }



    public static void sort(Comparable[] a){
       int N = a.length;
        aux = new Comparable[a.length];
        for(int size = 1 ; size < N ; size = size+size)
            for(int lo = 0 ; lo < N -size ; lo = lo+size+size)
                BottomUpMergeSort.merge(a, lo, lo+size+1, Math.min(lo+size+size-1, N-1));
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    public static void main(String[] argv){


        Comparable[] a = new Integer[] {1,3,5,7,9,2,4,6,8,10};
        BottomUpMergeSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
