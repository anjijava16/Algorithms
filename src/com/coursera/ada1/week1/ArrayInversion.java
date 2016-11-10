package com.coursera.ada1.week1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sunilpatil on 11/4/16.
 */
public class ArrayInversion {
    int[] temp;
    public static void main(String[] argv) throws Exception {
        ArrayInversion arrayInversion = new ArrayInversion();
        int[] inputArray = arrayInversion.readArray(argv[0]);
        long startTime = System.currentTimeMillis();
        long noOfInversions = arrayInversion.countInversion(inputArray);
        System.out.println("NonRecursive, Total time " + (System.currentTimeMillis() - startTime) + " No of inversions " + noOfInversions);
        startTime = System.currentTimeMillis();
        noOfInversions = arrayInversion.countInversionRecursive(inputArray);
        System.out.println("Recursive, Total time " + (System.currentTimeMillis() - startTime) + " No of inversions " + noOfInversions);
        //    System.out.println("Number of inversions " + noOfInversions);
    }

    public long countInversion(int[] a) {
        long inversions = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j])
                    inversions++;
            }
        }
        return inversions;
    }

    public long countInversionRecursive(int[] a) {
        temp = new int[a.length];
        return merge_and_count(a, 0, a.length - 1);
    }

    public long merge_and_count(int[] a, int start, int end) {
        if (start < end) {
            int middle = start + ((end - start) / 2);
            long x = merge_and_count(a, start, middle);
            long y = merge_and_count(a, middle + 1, end);
            long z = merge_and_countSplit(a, start, middle, end);
            return x + y + z;
        } else
            return 0;
    }

    public long merge_and_countSplit(int[] a, int start, int middle, int end) {
        for (int i = start; i <= end; i++)
            temp[i] = a[i];
        int splitCount = 0;
        int i = start;
        int j = middle + 1;

        for (int k = start; k <= end; k++) {
            if (i > middle) {
                a[k] = temp[j++];
            } else if (j > end) {
                a[k] = temp[i++];
            } else {
                if (temp[i] < temp[j]) {
                    a[k] = temp[i++];
                } else {
                    a[k] = temp[j++];
                    splitCount = splitCount + (middle - i) + 1;
                }
            }
        }

        return splitCount;
    }

    public boolean less(int a, int b) {
        return a < b;
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

}
