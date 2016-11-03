package com.algo4.chapter5;


import edu.princeton.cs.algs4.StdIn;

import java.util.HashSet;

/**
 * Created by sunilpatil on 10/28/16.
 */
public class Alphabets {
    Character[] currentChars;

    Alphabets(String s) {
        HashSet<Character> characterHashSet = new HashSet<>();
        for (Character c : s.toCharArray())
            characterHashSet.add(c);
        currentChars = new Character[characterHashSet.size()];

        characterHashSet.toArray(currentChars);
    }

    public static void main(String[] argv) {
        Alphabets alphabet = new Alphabets(argv[0]);
        int R = alphabet.R();
        int[] count = new int[R];

        String s = StdIn.readAll();
        int N = s.length();
        for (int i = 0; i < N; i++)
            if (alphabet.contains(s.charAt(i)))
                count[alphabet.toIndex(s.charAt(i))]++;

        for (int c = 0; c < R; c++)
            System.out.println(alphabet.toChar(c) + " " + count[c]);
    }

    public char toChar(int index) {
        return currentChars[index];
    }

    public int toIndex(char c) {
        for (int i = 0; i < currentChars.length; i++)
            if (currentChars[i].equals(c))
                return i;
        return -1;
    }

    public boolean contains(char c) {
        return toIndex(c) != -1;
    }

    public int R() {
        return currentChars.length;
    }

    public int lgR() {
        return 0;//Math.log(currentChars.length);
    }

    public int[] toIndices(String s) {
        return null;
    }

    public String toChars(int[] indices) {
        return null;
    }
}
