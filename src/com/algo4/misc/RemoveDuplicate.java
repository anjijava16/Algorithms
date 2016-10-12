package com.algo4.misc;

/**
 * Given array of character, remove duplicates
 * Created by sunilpatil on 10/12/16.
 */
public class RemoveDuplicate {
    public static void main(String[] argv) {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        char[] inputString = "Hello World".toCharArray();
        removeDuplicate.removeDuplicate(inputString);
        System.out.println("De-duplicated String " + new String(inputString));
    }

    public void removeDuplicate(char[] chars) {
        boolean[] charPresence = new boolean[256];
        int length = chars.length;

        int charCounter = 0;
        while (charCounter < length) {
            if (charPresence[chars[charCounter]]) {
                //Character is already present in the string, remove it
                System.out.println("Found duplicate chars " + (char) chars[charCounter]);
                chars[charCounter] = chars[length - 1];
                chars[length - 1] = (char) 0;
                length--;
            } else {
                charPresence[chars[charCounter]] = true;
                charCounter++;
            }
        }
    }
}
