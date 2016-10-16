package com.algo4.misc;

/**
 * Given a String find first repeating or non-repeating character in the string
 * Created by sunilpatil on 10/12/16.
 */
public class FindFirstNonRepeatingCharacter {
    public static void main(String[] argv) {
        FindFirstNonRepeatingCharacter findFirstNonRepeatingCharacter = new FindFirstNonRepeatingCharacter();
        System.out.println(findFirstNonRepeatingCharacter.firstNonRepeatingCharacter("abzddab"));
        System.out.println(findFirstNonRepeatingCharacter.firstRepeatingCharacter("Sunil Patil"));
    }

    public char firstNonRepeatingCharacter(String str) {
        char[] c = str.toCharArray();
        int[] frequencyCounter = new int[256];
        for (int i = 0; i < c.length; i++) {
            frequencyCounter[c[i]] = frequencyCounter[c[i]] + 1;
        }
        for (int i = 0; i < c.length; i++) {
            if (frequencyCounter[c[i]] == 1)
                return c[i];
        }
        return 0;
    }

    public char firstRepeatingCharacter(String str) {
        char[] c = str.toCharArray();
        int[] frequencyCounter = new int[256];
        for (int i = 0; i < 256; i++)
            frequencyCounter[i] = 0;

        for (int i = 0; i < c.length; i++) {
            frequencyCounter[c[i]] = frequencyCounter[c[i]] + 1;
        }
        for (int i = 0; i < c.length; i++) {
            if (frequencyCounter[c[i]] == 2)
                return c[i];
        }
        return 0;
    }
}
