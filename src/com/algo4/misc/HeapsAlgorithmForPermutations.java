package com.algo4.misc;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by sunilpatil on 10/8/16.
 */
public class HeapsAlgorithmForPermutations {

    private static int counter = 0;

    public static void main(String[] argv) {
        char[] p = "hefg".toCharArray();
        HashSet<String> wordCombSet = new HashSet<>();
        perm(p, p.length, wordCombSet);
        System.out.println("Number of combinations " + counter);
        for (String s : wordCombSet)
            System.out.println(s);

        Arrays.sort(wordCombSet.toArray());
    }

    private static void perm(int[] list, int n) {
        if (n == 1) {
            counter++;
            System.out.println(Arrays.toString(list));
        } else {
            for (int i = 0; i < n; i++) {
                perm(list, n - 1);

                int j = (n % 2 == 0) ? i : 0;
                int t = list[n - 1];
                list[n - 1] = list[j];
                list[j] = t;
            }
        }
    }

    private static void perm(char[] list, int n, HashSet<String> permList) {
        if (n == 1) {
            permList.add(new String(list));
        } else {
            for (int i = 0; i < n; i++) {
                perm(list, n - 1, permList);

                int j = (n % 2 == 0) ? i : 0;
                char t = list[n - 1];
                list[n - 1] = list[j];
                list[j] = t;
            }
        }

    }
}
