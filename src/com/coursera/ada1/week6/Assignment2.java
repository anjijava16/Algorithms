package com.coursera.ada1.week6;

import java.io.File;
import java.util.Scanner;

/**
 * Created by sunilpatil on 12/8/16.
 */
public class Assignment2 {

    public static void main(String[] argv) throws Exception {
        MedianMaintanence medianMaintanence = new MedianMaintanence(10000);
        Scanner scanner = new Scanner(new File(argv[0]));
        int median = 0;
        while (scanner.hasNextInt()) {
            int nextInt = scanner.nextInt();
            medianMaintanence.insert(nextInt);
            median = median + medianMaintanence.getCurrentMedian();
        }
        System.out.println(median);
    }
}
