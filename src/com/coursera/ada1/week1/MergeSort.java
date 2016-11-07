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

    /*
    public void sort(int[] a, int start, int end){
        System.out.printf("Inside sort start -> %d end -> %d \n", start, end);
        int length = end -start;
        if(length <1 )
            return;
        int middle = start + (end-start)/2;
        sort(a, start, middle);
        sort(a, middle+1, end);
        merge(a, start, middle, end);
    }*/
/*
    public void sort(int[] a, int start, int end){
      //  System.out.printf("Inside merge Start -> %d End -> %d \n",start,end);

        if(start < end){
          //  int middle = start+((end - start)/2);
            int middle = (end+start)+2;
            sort(a, start, middle);
            sort(a, middle+1, end);
            merge(a, start,middle,end);
        }
    }
    */
    private void sort(int[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public void merge(int[] a, int start, int middle, int end) {
        System.out.printf("Inside merge Start -> %d End -> %d \n", start, end);
        int leftSize = middle - start + 2;
        int rightSize = end - middle + 1;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        int counter = 0;
        for (int i = start; i <= middle; i++)
            left[counter++] = a[i];
        left[counter] = Integer.MAX_VALUE;

        counter = 0;
        for (int i = middle; i < end; i++)
            right[counter++] = a[i];
        right[counter] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = start; k < end; k++)
            if (left[i] <= right[j]) {
                a[k] = left[i++];
            } else {
                a[k] = right[j++];
            }

    }
/*
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
*/

    public boolean less(int a, int b) {
        return a < b;
    }

    public void exch(int[] a, int f, int s) {
        int temp = a[f];
        a[f] = a[s];
        a[s] = temp;
    }

}
