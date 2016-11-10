package com.coursera.ada1.week1;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sunilpatil on 11/4/16.
 */
public class ArrayInversionTest {
    ArrayInversion arrayInversion = new ArrayInversion();

    @Test
    public void testCountInversion() {
        int[] a = new int[]{1, 3, 5, 2, 4, 6};
        System.out.println("Number of inversions, non recursive " + arrayInversion.countInversion(a));
        long inversions = arrayInversion.countInversionRecursive(a);
        System.out.println(Arrays.toString(a));
        assert isSorted(a);
        System.out.println("No of inversions " + inversions);
        //assert arrayInversion.countInversionRecursive(a) == 3;

    }

    @Test
    public void testReverseArray() {
        assert arrayInversion.countInversionRecursive(new int[]{6, 5, 4, 3, 2, 1}) == 15;
    }

    @Test
    public void testSortedArray() {
        assert arrayInversion.countInversionRecursive(new int[]{1, 2, 3, 4, 5, 6}) == 0;
    }

    @Test
    public void testReverseInversion() {
        System.out.println(arrayInversion.countInversion(new int[]{4, 5, 6, 1, 2, 3}));

        System.out.println(arrayInversion.countInversionRecursive(new int[]{4, 5, 6, 1, 2, 3}));
    }

    public boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i])
                return false;
        }
        return true;
    }
}
