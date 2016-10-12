package com.algo4.misc;

/**
 * Created by sunilpatil on 10/11/16.
 */
public class CharacterFrequency {

    public static void main(String[] argv) {
        printCharFrequency("Sunil Patil");
    }

    public static void printCharFrequency(String str) {
        char[] c = str.toCharArray();
        int[] frequencyCounter = new int[256];
        for (int i = 0; i < c.length; i++) {
            frequencyCounter[c[i]] = frequencyCounter[c[i]] + 1;
        }
        for (int i = 0; i < frequencyCounter.length; i++) {
            if (frequencyCounter[i] != 0)
                System.out.println((char) i + " -> " + frequencyCounter[i]);
        }
    }

}
