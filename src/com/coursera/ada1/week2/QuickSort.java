package com.coursera.ada1.week2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sunilpatil on 11/10/16.
 */
public class QuickSort {

    long count = 0;
    long count2 = 0;

    public static void main(String[] argv) throws Exception {
        QuickSort quickSort = new QuickSort();
        int[] a = quickSort.readArray(argv[0]);
        quickSort.quicksort(a);
        System.out.println("isSorted -> " + quickSort.isSorted(a));
        System.out.println("Count -> " + quickSort.count);
        System.out.println("Count2 -> " + quickSort.count2);

    }


    private int[] readArray(String filePath) throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextInt()) {
            arrayList.add(scanner.nextInt());
        }
        int[] returnArray = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++)
            returnArray[i] = arrayList.get(i);

        return returnArray;
    }

    public void quicksort(int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    private void quicksort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int q = partitionMedianElement(a, lo, hi);
            count2 = count2 + (q - lo);
            quicksort(a, lo, q - 1);
            count2 = count2 + (hi - q);

            quicksort(a, q + 1, hi);
        }
    }

    /*
    private int partition (int[] a, int lo, int hi){
        int x = a[hi];
        int i = lo;
        for(int j = lo+1; j < hi-1; j++){
            if(a[j] <= x){
                i++;
                swap(a,i,j);
            }
        }
        swap(a, i+1,hi);
        return i+1;
    }*/

    // Partition with first element as pivot
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

    private int partitionLastElement(int[] a, int l, int r) {
        swap(a, l, r);
        return partition(a, l, r);
    }

    // Partition with last element as pivot
    /*private int partitionLastElement(int[] a, int l, int r){
        int p = a[r];
        int i = l;
        for(int j = l ; j < r; j++){
            if(less(a[j],p) ){
                //i++;
                swap(a,i,j);
                i ++;
            }
        }
        swap(a, i,r);
        return i;
    }*/

    // Partition with last element as pivot
    private int partitionMedianElement(int[] a, int l, int r) {
        int[] m = new int[3];
        m[0] = a[l];
        m[1] = a[r];

        int middle = 0;
        if (r - l % 2 == 0)
            middle = l + ((r - l) / 2) + 1;
        else
            middle = l + ((r - l) / 2);
        m[2] = a[middle];
        Arrays.sort(m);

        if (m[1] == a[middle]) {
            swap(a, l, middle);
        } else if (m[1] == a[r]) {
            swap(a, l, r);
        }


        return partition(a, l, r);
    }

    private boolean less(int i, int j) {
        count = count + 1;
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

    public boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i])
                return false;
        }
        return true;
    }

}
