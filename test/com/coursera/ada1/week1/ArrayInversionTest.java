package com.coursera.ada1.week1;

import org.junit.Test;

/**
 * Created by sunilpatil on 11/4/16.
 */
public class ArrayInversionTest {
    ArrayInversion arrayInversion = new ArrayInversion();

    @Test
    public void testCountInversion() {
        assert arrayInversion.countInversion(new Integer[]{6, 5, 4, 3, 2, 1}) == 15;
        assert arrayInversion.countInversion(new Integer[]{1, 3, 5, 2, 4, 6}) == 3;

    }
}
