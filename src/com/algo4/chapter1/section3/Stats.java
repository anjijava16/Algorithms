package com.algo4.chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by sunilpatil on 9/12/16.
 */
public class Stats {
    public static void main(String[] argv){
        Bag<Double> numbers = new Bag<>();

        while(!StdIn.isEmpty()){
            double d = StdIn.readDouble();
            if(d == -1)
                break;
            numbers.add(d);
        }

        int N = numbers.size();

        double sum = 0.0;
        for(double x: numbers)
            sum = sum + x;

        double mean = sum/N;

        sum = 0.0;
        for(double x : numbers){
            sum = sum + (x - mean) * (x -mean);
        }
        double std = Math.sqrt(sum/(N-1));

        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
