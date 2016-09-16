package com.algo4.chapter1.section1.exercise;

/**
 * Created by sunilpatil on 8/29/16.
 */
public class Exercise1113 {
    public static void main(String[] argv){
        int[][] a = new int[2][3];
        printTransposition(a);
    }

    public static void printTransposition(int[][] array){
      int rows = array.length;
      int columns = array[0].length;

      for(int i =0; i< rows ; i++ )
          System.out.print(i +" ");
      System.out.println();

    }
}
