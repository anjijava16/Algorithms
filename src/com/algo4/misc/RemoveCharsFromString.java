package com.algo4.misc;

import java.util.Arrays;

/**
 * Give an algorithm to remove the specified character from a string which are given in another string
 * Created by sunilpatil on 10/12/16.
 */
public class RemoveCharsFromString {
    public static void main(String[] argv) {
        RemoveCharsFromString removeCharsFromString = new RemoveCharsFromString();

        System.out.println(removeCharsFromString.removeChar("Sunil Patil", "Sunil"));
    }

    public String removeChar(String mainString, String removeCharString) {
        boolean[] removeCharDict = new boolean[256];
        char[] removeChar = removeCharString.toCharArray();

        for (int i = 0; i < removeChar.length; i++) {
            removeCharDict[(int) removeChar[i]] = true;
        }

        char[] mainStringChars = mainString.toCharArray();
        int length = mainString.length();
        int counter = 0;
        while (counter < length) {
            if (removeCharDict[mainStringChars[counter]]) {
                mainStringChars[counter] = mainStringChars[length - 1];
                mainStringChars[length - 1] = '\0';
                length = length - 1;
            } else {
                counter++;
            }
        }
        return new String(Arrays.copyOf(mainStringChars, length));
    }
}
