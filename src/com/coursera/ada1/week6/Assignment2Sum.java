package com.coursera.ada1.week6;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by sunilpatil on 12/6/16.
 */
public class Assignment2Sum {
    int lowerBound;
    int higherBound;

    public Assignment2Sum(int lowerBound, int higherBound) {
        this.lowerBound = lowerBound;
        this.higherBound = higherBound;
    }

    public static void main(String[] argv) throws Exception {
        Assignment2Sum assignment = new Assignment2Sum(-10000, 10000);
        HashSet<Long> numSet = assignment.readArray(argv[0]);
        System.out.println("Number of distinct records " + numSet.size());
        int combinations = assignment.calculate2Sum(numSet);
        System.out.println("Value of counter " + combinations);
    }

    public int calculate2Sum1(HashSet<Long> numSet) {
        long[] numbers = convertHashSet(numSet);
        numSet = null;
        Arrays.sort(numbers);
        int counter = 0;
        HashSet<Long> combinations = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Processing number " + i);
            long firstNum = numbers[i];
            for (int j = i; j < numbers.length; j++) {
                long secondNum = numbers[j];
                long total = firstNum + secondNum;
                if (total >= lowerBound && total <= higherBound)
                    combinations.add(total);

                if (total >= higherBound)
                    continue;

            }
        }
        return combinations.size();
    }

    public int calculate2Sum(HashSet<Long> numSet) {
        Iterator<Long> it = numSet.iterator();
        HashSet<Integer> total = new HashSet<>();
        int counter = 0;
        while (it.hasNext()) {
            Long x = it.next();
            if (counter % 10000 == 0)
                System.out.println("Processing record no " + counter);
            counter++;
            for (int i = lowerBound; i <= higherBound; i++) {
                if (total.contains(i))
                    continue;
                long y = i - x;
                if (numSet.contains(y)) {
                    if (x != y) {
                        //            System.out.println("Adding, x " + x + " y " + y);
                        total.add(i);
                    } else {
//                        System.out.println("Skipping, x " + x + " y " + y);

                    }
                }
            }
        }
        //      System.out.println("Number of records found " + total);
        System.out.println("Number of records found " + total.size());

        return total.size();
    }

    private long[] convertHashSet(HashSet<Long> longSet) {
        long[] keyArray = new long[longSet.size()];
        int counter = 0;
        Iterator<Long> keySet = longSet.iterator();
        while (keySet.hasNext()) {
            keyArray[counter++] = keySet.next();
        }
        return keyArray;
    }

    public HashSet<Long> readArray(String filePath) throws Exception {
        HashSet<Long> numSet = new HashSet<>();

        Scanner scanner = new Scanner(new File(filePath));
        int counter = 0;
        while (scanner.hasNextLong()) {
            counter++;
            numSet.add(scanner.nextLong());
        }
        System.out.println("Number of lines read " + counter);
        return numSet;
    }
}
