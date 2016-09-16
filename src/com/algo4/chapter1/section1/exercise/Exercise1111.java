package com.algo4.chapter1.section1.exercise;

/**
 * Created by sunilpatil on 8/29/16.
 */
public class Exercise1111 {

    public static void main(String[] argv){
        boolean[][] a = new boolean[3][2];
        a[0][1] = true;
        a[1][0] = true;
        printBooleanArray(a);
    }

    public static void printBooleanArray(boolean[][] array){
        int rows = array.length;
        System.out.print("  ");
        int columns = array[0].length;
        for(int i = 0; i< columns;i++ )
            System.out.print(i +" ");
        System.out.println();
        for(int i = 0; i < rows;i++){
            System.out.print(i +" ");
            for(int j = 0; j< columns;j++){
                if(array[i][j]){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
