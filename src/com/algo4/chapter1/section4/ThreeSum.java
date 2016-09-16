package com.algo4.chapter1.section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by sunilpatil on 9/2/16.
 */
public class ThreeSum {
    public static void main(String[] argv){
        int[] a = In.readInts(argv[0]);
        Stopwatch timer = new Stopwatch();
        StdOut.println(count(a));
        System.out.println("Time to execute " +timer.elapsedTime());
    }

    public static int count(int[] a){
        int count =0;
        for(int i = 0; i < a.length; i++){

            for(int j =i+1 ; j< a.length;j++){

                for(int k = j+1 ; k< a.length; k++){
                    if(a[i] + a[j] + a[k] == 0)
                        count++;
                }
            }
        }
        return count;
    }
}
