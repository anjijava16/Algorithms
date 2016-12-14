package com.coursera.ada1.week6;

import org.junit.Test;

import java.util.HashSet;

/**
 * Created by sunilpatil on 12/7/16.
 */
public class Assignment2SumTest {

    Assignment2Sum assignment2Sum;

    @Test
    public void testSimple() {
        assignment2Sum = new Assignment2Sum(-2, 4);
        HashSet<Long> input = new HashSet<>();
        input.add((long) -5);
        input.add((long) -5);
        input.add((long) -2);
        input.add((long) -1);
        input.add((long) 2);
        input.add((long) 2);
        input.add((long) 3);
        input.add((long) 3);
        input.add((long) 5);
        input.add((long) 9);


        assert assignment2Sum.calculate2Sum(input) == 6;
    }

    @Test
    public void testSimple2() {
        System.out.println(-3 + (-2));
        System.out.println(-5 - (-2));

        System.out.println(-1 + 3);
        System.out.println(2 - (-1));
    }
}
