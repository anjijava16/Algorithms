package com.algo4.misc;

/**
 * Created by sunilpatil on 10/11/16.
 */
public class FirstRepeatedCharacter {

    public static void main(String[] argv) {
        System.out.println(FirstRepeatedCharacter.firstRepeatedChar("Sunil Patil".toCharArray()));
    }

    public static char firstRepeatedChar(char[] str) {
        boolean[] charHash = new boolean[256];
        for (char c : str) {
            if (charHash[(int) c]) {
                System.out.println("Found repeating char " + c);
                return c;
            } else
                charHash[(int) c] = true;
        }
        return 0;
    }
}
