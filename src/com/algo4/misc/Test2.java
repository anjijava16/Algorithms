package com.algo4.misc;

/**
 * import java.io.*;
 * import java.util.*;
 * <p>
 * /*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 * <p>
 * If you need more classes, simply define them inline.
 * <p>
 * <p>
 * class Solution {
 * public static void main(String[] args) {
 * ArrayList<String> strings = new ArrayList<String>();
 * strings.add("Hello, World!");
 * strings.add("Welcome to CoderPad.");
 * strings.add("This pad is running Java 8.");
 * <p>
 * for (String string : strings) {
 * System.out.println(string);
 * }
 * }
 * <p>
 * public int[][] createDS(int[] numbers){
 * int[][] a = new int[5][5];
 * <p>
 * int row = 0;
 * int column = 0;
 * for(int i :numbers){
 * a[row][column] = numbers[i];
 * if(row == column){
 * row = row++;
 * column = 0;
 * }
 * column = column+1;
 * }
 * return a;
 * }
 * <p>
 * <p>
 * <p>
 * }
 * <p>
 * <p>
 * /*
 * Your previous Plain Text content is preserved below:
 * <p>
 * This is just a simple shared plaintext pad, with no execution capabilities.
 * <p>
 * When you know what language you'd like to use for your interview,
 * simply choose it from the dropdown in the top bar.
 * <p>
 * You can also change the default language your pads are created with
 * in your account settings: https://coderpad.io/profile
 * <p>
 * Enjoy your interview!
 * <p>
 * Question 1:
 * <p>
 * 6
 * 3   8
 * 9   4   1
 * 2   6   3   4
 * 8   2   1   4   6
 * <p>
 * 6
 * 3   8
 * 9   4   1
 * 2   6   3   4
 * 8   2   1   4   6
 * <p>
 * Target:
 * 1. design a data structure to store the data
 * 2. find out the path with max of the sum
 * <p>
 * <p>
 * <p>
 * <p>
 * target 2:
 * <p>
 * int getMaxSum(int[][] arr) {
 * int maxSum = 0;
 * return getMaxSum(arr,1,0,0);
 * }
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * int getSum(int[][] arr, int row, int column, int currentSum){
 * if( row > arr.length)
 * return 0;
 * int leftChild = arr[row+1][column];
 * int rightChild = arr[row+1][column+1];
 * if(leftChild > rightChild)
 * return getSum( arr, row+1, column, currentSum + leftChild );
 * else
 * return getSum( arr, row+1, column+1, currentSum + rightChild );
 * }
 * <p>
 * <p>
 * .
 */
public class Test2 {
}
