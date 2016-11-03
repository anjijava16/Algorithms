package com.salesforce;

import java.util.HashSet;

/**
 * Created by spatil30 on 11/2/2016.
 * Find a 1st non-repeated char in the string for e.g.
 * if string is "Salesforce is the best company to work for” returns 'l'
 */
public class FirstNotRepeatedChar {
    public static void main(String[] argv){
        FirstNotRepeatedChar firstNotRepeatedChar = new FirstNotRepeatedChar();
        System.out.println(firstNotRepeatedChar.firstNonRepeatedChar("Sunilsunil"));
        System.out.println(firstNotRepeatedChar.firstNonRepeatedChar("Salesforce is the best company to work for"));
        System.out.println(firstNotRepeatedChar.firstNonRepeatedChar("Salesforce is the best company to work for") == 'l');

    }

    public char firstNonRepeatedChar(String s){
        int[] charCounter = new int[256];
        char[] chars = s.toCharArray();
        for(char c: chars){
            charCounter[Character.toLowerCase(c)]++;
        }
        for(char c: chars){
            if(charCounter[Character.toLowerCase(c)] ==1)
                return c;
        }
        return '0';
    }
}
