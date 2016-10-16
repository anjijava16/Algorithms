package com.cci;

/**
 * Created by sunilpatil on 10/13/16.
 */
public class Chapter1 {

    public static void main(String[] argv) {
        Chapter1 chapter1 = new Chapter1();
        System.out.println(chapter1.reverseString("Sunil Patil"));
    }

    public String reverseString(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            char t = chars[start];
            chars[start] = chars[end];
            chars[end] = t;
            start++;
            end--;
        }
        return new String(chars);
    }

    /**
     * Design an algorithm and write code to remove the duplicate characters in a string without using any additional bu er NOTE: One or two additional variables are  ne An extra copy of the array is not
     *
     * @param str
     * @return
     */
    public String removeDuplicate(String str) {
        return null;
    }
}
