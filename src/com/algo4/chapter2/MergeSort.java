package com.algo4.chapter2;

import java.util.Arrays;

/**
 * Created by sunilpatil on 9/19/16.
 */
public class MergeSort<Item>  {
    private static Comparable[] aux;
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
    {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

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

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo)
            return;
        int mid = lo + (hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    public static void main(String[] argv){


        Comparable[] a = new Integer[] {1,3,5,7,9,2,4,6,8,10};
        MergeSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
