package com.clrs;

import java.util.Stack;

/**
 * Created by sunilpatil on 12/10/16.
 */
public class HelloBitManipulation {

    public static void main(String[] argv) {
        HelloBitManipulation helloBitManipulation = new HelloBitManipulation();

        System.out.println("Binary Value " + helloBitManipulation.convertDecimalToBinary(15));
        System.out.println("Decimal Value " + helloBitManipulation.convertBinaryToDecimal("1111"));


    }

    public String convertDecimalToBinary(int number) {
        int n = number;
        Stack<String> str = new Stack<>();
        while (n > 0) {
            str.push(n % 2 + "");
            n = n / 2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!str.empty())
            stringBuffer.append(str.pop());
        return stringBuffer.toString();
    }

    public int convertBinaryToDecimal(String binaryStr) {
        int decimalValue = 0;
        int twosPlace = 0;
        char[] c = binaryStr.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == '1')
                decimalValue = decimalValue + (int) Math.pow(2, twosPlace++);
            else
                twosPlace++;

        }
        return decimalValue;
    }
}
