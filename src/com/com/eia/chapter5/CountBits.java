package com.com.eia.chapter5;

/**
 * Created by sunilpatil on 12/23/16.
 */
public class CountBits {

    public static void main(String[] argv) {
        CountBits countBits = new CountBits();
        System.out.println(countBits.calculateParity(6));
    }

    public int countNumberOfOneBits(int x) {
        int counter = 0;
        while (x != 0) {
            System.out.println(x + " -> " + Integer.toBinaryString(x));
            if ((x & 1) == 1)
                counter++;
            x = x >>> 1;
        }
        return counter;
    }

    public int calculateParity(int x) {
        int counter = 0;
        while (x != 0) {
            System.out.println(x + " -> " + Integer.toBinaryString(x));
            if ((x & 1) == 1)
                counter++;
            x = x >>> 1;
        }
        if (counter % 2 == 1)
            return 1;

        return 0;
    }

    public int countNumberOfZeroBits(int x) {
        int counter = 0;
        while (x != 0) {
            System.out.println(x + " -> " + Integer.toBinaryString(x));
            if ((~x) == 1)
                counter++;
            x = x >>> 1;
        }
        return counter;
    }


}
