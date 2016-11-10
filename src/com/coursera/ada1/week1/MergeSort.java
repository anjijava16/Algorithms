package com.coursera.ada1.week1;

/**
 * Created by sunilpatil on 11/4/16.
 */
public class MergeSort {

    int[] temp;

    public void sort(int[] a) {
        temp = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    public void sort(int[] a, int start, int end){

        if(start < end){
            int middle = start + ((end - start) / 2);
            sort(a, start, middle);
            sort(a, middle+1, end);
            merge(a, start,middle,end);
        }
    }


    public  void merge(int[] a, int lo, int mid, int hi){
        int i =lo, j = mid+1;
        for(int k = lo ; k <= hi ;k++)
            temp[k] = a[k];

        for(int k = lo; k <= hi ; k++){
            if(i >mid)
                a[k] = temp[j++];
            else if(j > hi)
                a[k] = temp[i++];
            else {
                if(less(temp[i], temp[j])){
                    a[k] = temp[i++];
                }else{
                    a[k] = temp[j++];

                }
            }
        }
    }


    public boolean less(int a, int b) {
        return a < b;
    }

    public void exch(int[] a, int f, int s) {
        int temp = a[f];
        a[f] = a[s];
        a[s] = temp;
    }

}
