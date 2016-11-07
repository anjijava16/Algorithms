package com.codility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sunilpatil on 11/6/16.
 */
public class Problem2 {
    public static void main(String[] argv) {
        Problem2 problem2 = new Problem2();
        System.out.println(problem2.solution(new int[]{1, 0, 0, 1, 1, 1}));

        for (int i = 0; i < 10; i++)
            System.out.println(i + " " + (int) Math.pow(-2, i));
    }

    public int[] solution(int[] A) {
        int sum = convertArrayToInt(A);
        System.out.println("Value of input " + sum);
        System.out.println("Value of return " + -sum);
        System.out.println(Arrays.toString(convertBinary(-sum)));
        //    System.out.println("Value of Integer.toString " + Integer.toString(9, 2));
        // write your code in Java SE 8
        return null;
    }

    private int convertArrayToInt(int[] A) {
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i] * (int) (Math.pow(-2, i));
        }
        return sum;
    }

    private int[] convertIntToArray(int sum) {
        ArrayList<Integer> returnValue = new ArrayList<>();
        //    while ( sum >  )
        return null;
    }

    public int[] convertBinary(int no) {
        int i = 0, temp[] = new int[100];
        int binary[];
        boolean flag = true;

        while (no > 0) {
            temp[i++] = no % 2;
            no /= 2;
        }


        return temp;
    }

}
