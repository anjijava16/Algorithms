package com.coursera.ada1.week1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sunilpatil on 11/4/16.
 */
public class ArrayInversion {
    public static void main(String[] argv) throws Exception {
        ArrayInversion arrayInversion = new ArrayInversion();
        Integer[] inputArray = arrayInversion.readArray(argv[0]);
        long noOfInversions = arrayInversion.countInversion(inputArray);

        System.out.println("Number of inversions " + noOfInversions);
    }

    public long countInversion(Integer[] a) {
        long inversions = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j])
                    inversions++;
            }
        }
        return inversions;
    }


    private Integer[] readArray(String filePath) throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextInt()) {
            arrayList.add(scanner.nextInt());
        }
        Integer[] returnArray = new Integer[arrayList.size()];
        return arrayList.toArray(returnArray);
    }

}
