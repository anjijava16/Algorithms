package com.coursera.ada1.week1;

/**
 * Created by sunilpatil on 11/8/16.
 */
public class MatrixMultiplication {

    public int[][] multiplication(int[][] a, int[][] b) {
        int[][] product = new int[a.length][a.length];

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length; j++) {
                int sum = 0;

                for (int k = 0; k < a.length; k++) {
                    sum = sum + (a[i][k] * b[k][j]);
                    System.out.printf("i -> %d + j -> %d k -> %d \n", i, j, k);
                }
                product[i][j] = sum;
                System.out.printf("Value of i -> %d j -> %d sum -> %d \n\n", i, j, sum);
            }

        }

        return product;

    }

}
