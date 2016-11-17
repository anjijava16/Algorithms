package com.coursera.ada1.week3;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by sunilpatil on 11/14/16.
 */
public class RandomSelectionTest {
    RandomSelection randomSelection;

    @Before
    public void setup() {
        randomSelection = new RandomSelection();
    }

    @Test
    public void test() {
        int[] a = new int[]{5, 2, 8, 4, 1};
        int nthIndex = randomSelection.randomizedSelect(a, 3);
        System.out.println("3rd index " + nthIndex);
        assert nthIndex == 4;
    }

    @Test
    public void test4th() {
        int[] a = new int[]{5, 2, 8, 4, 1};
        int nthIndex = randomSelection.randomizedSelect(a, 4);
        System.out.println("4th index " + nthIndex);
        assert nthIndex == 5;
    }

    @Test
    public void testFirst() {
        int[] a = new int[]{5, 2, 8, 4, 1};
        int nthIndex = randomSelection.randomizedSelect(a, 1);
        System.out.println("1st index " + nthIndex);
        assert nthIndex == 1;
    }

    @Test
    public void testLast() {
        int[] a = new int[]{5, 2, 8, 4, 1};
        int nthIndex = randomSelection.randomizedSelect(a, 5);
        System.out.println("5th index " + nthIndex);
        assert nthIndex == 8;
    }
}
