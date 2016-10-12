package com.algo4.misc;

import java.util.HashMap;

/**
 * Given 2 arrays of unordered numbers, check whether both arrays have the same set of numbers ?
 * Created by sunilpatil on 10/12/16.
 */
public class DuplicateNumbersIn2Arrays {

    public static void main(String[] argv) {
        DuplicateNumbersIn2Arrays dni2a = new DuplicateNumbersIn2Arrays();
        System.out.println("Same elements ->" + dni2a.checkDuplicates(new int[]{1, 2, 3, 4, 2, 2, 3}, new int[]{4, 3, 2, 1}));
    }

    public boolean checkDuplicates(int[] a, int[] b) {
        HashMap<Integer, Integer> members = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (members.containsKey(a[i])) {
                int count = members.get(a[i]);
                members.put(a[i], count + 1);
            } else {
                members.put(a[i], 1);
            }
        }

        for (int i = 0; i < b.length; i++) {
            if (members.containsKey(b[i])) {
                int count = members.get(b[i]);
                if (count < 1) {
                    return false;
                } else if (count == 1)
                    members.remove(b[i]);
                else
                    members.put(a[i], count - 1);
            } else {
                return false;
            }
        }
        if (members.size() != 0)
            return false;
        return true;
    }
}
