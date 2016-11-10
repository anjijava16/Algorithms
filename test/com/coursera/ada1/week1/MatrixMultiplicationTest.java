package com.coursera.ada1.week1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sunilpatil on 11/8/16.
 */
public class MatrixMultiplicationTest {
    MatrixMultiplication matrixMultiplication;

    @Before
    public void setup() {
        matrixMultiplication = new MatrixMultiplication();
    }

    @Test
    public void testTwoByTwo() {
        int[][] a = new int[2][2];
        a[0][0] = 2;
        a[0][1] = -2;
        a[1][0] = 5;
        a[1][1] = 3;

        printMultiDimensionalArrays(a);

        int[][] b = new int[2][2];
        b[0][0] = -1;
        b[0][1] = 4;
        b[1][0] = 7;
        b[1][1] = -6;
        printMultiDimensionalArrays(b);

        int[][] c = matrixMultiplication.multiplication(a, b);
        printMultiDimensionalArrays(c);

        assert c[0][0] == -16;
        assert c[0][1] == 20;
        assert c[1][0] == 16;
        assert c[1][1] == 2;
    }

    @Test
    public void testThreeByThree() {
        int[][] a = new int[3][3];
        a[0][0] = 1;
        a[0][1] = 2;
        a[0][2] = 3;

        a[1][0] = 4;
        a[1][1] = 5;
        a[1][2] = 6;

        a[2][0] = 7;
        a[2][1] = 8;
        a[2][2] = 9;

        printMultiDimensionalArrays(a);

        int[][] b = new int[3][3];
        b[0][0] = 1;
        b[0][1] = 2;
        b[0][2] = 3;

        b[1][0] = 4;
        b[1][1] = 5;
        b[1][2] = 6;

        b[2][0] = 7;
        b[2][1] = 8;
        b[2][2] = 9;
        printMultiDimensionalArrays(b);

        int[][] c = matrixMultiplication.multiplication(a, b);
        printMultiDimensionalArrays(c);

        assert c[0][0] == 30;
        assert c[0][1] == 36;
        assert c[0][2] == 42;
        assert c[1][0] == 66;
    }

    public void printMultiDimensionalArrays(int[][] a) {
        System.out.println("[");
        for (int[] c : a)
            System.out.println(Arrays.toString(c));

        System.out.println("]\n");
    }

}
