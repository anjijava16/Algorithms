package com.algo4.chapter1.section1.exercise;

import java.util.Arrays;

/**
 * Created by sunilpatil on 8/30/16.
 */
public class Exercise1128 {

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

    public static int[] removeDuplicates(int[] a){
       int duplicates =  0;
       for(int i =1; i< a.length;i++){
           if(a[i] == a[i-1])
               duplicates++;
       }
        int[] a2 = new int[a.length-duplicates];
        int j =0;
        for(int i = 0; i < a.length;i++){
            if(i == 0 || a[i] != a[i-1])
                a2[j++] = a[i];
        }
        System.out.println("Number of duplicates " + duplicates);
        return a2;
    }


    public static int[] removeDuplicates2(int[] a){

        int[] a2 = new int[a.length];
        int j =0;
        for(int i = 0; i < a.length;i++){
            if(i == 0 || a[i] != a[i-1])
                a2[j++] = a[i];
        }
        a2 = Arrays.copyOf(a2,j);
        return a2;
    }



    public static void main(String[] argv){
        int[] whitelist = {16,10,9,5, 2, 5, 12, 16,2, 8, 7,5,10};
        Arrays.sort(whitelist);
        System.out.println("Before remove duplicate" +Arrays.toString(whitelist));

        whitelist = removeDuplicates2(whitelist);
        System.out.println("After remove duplicate " +Arrays.toString(whitelist));

        System.out.println(binarySearch1(10, whitelist));
    }
}
