package com.algo4.chapter2;

import edu.princeton.cs.algs4.Selection;

import java.util.Arrays;

/**
 * Created by sunilpatil on 10/2/16.
 */
public class HeapSort<Key extends Comparable<Key>> {

    public static void sort(Comparable[] pq){
        int N = pq.length;
        for(int k = N/2 ; k >=1 ; k--)
            sink(pq,k,N);
    }



    private static boolean less(Comparable[] pq,int i, int j){
        return pq[i-1].compareTo(pq[j-1]) <0;
    }

    private static void exch(Comparable[] pq,int i, int j){
        Comparable t= pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = t;
    }

    private  static void swim(Comparable[] pq,int k, int N){
        while(k>1&& less(pq,k/2,k)){
            exch(pq,k/2,k);
            k = k/2;
        }
    }

    private static void sink(Comparable[] pq,int k,int N){
        while(2*k < N){
            int j = 2*k;
            if (j <N && less(pq,j, j+1))
                j++;
            if(!less(pq,k,j))
                break;
            exch(pq,j,k);
            k = j;
        }
    }


    public static void main(String[] argv) {
        String[] strings = new String[]{"First", "Second", "Third", "Fourth", "Fifth", "Sixth",
                "Seventh", "Eigth", "Ninth", "Tenth"};
        System.out.println(Arrays.toString(strings));
        HeapSort.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
