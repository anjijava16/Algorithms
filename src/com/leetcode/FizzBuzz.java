package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunilpatil on 11/2/16.
 */
public class FizzBuzz {
    public static void main(String[] argv) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(3));
    }

    public List<String> fizzBuzz(int n) {
        List<String> returnList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            returnList.add(getString(i));
        }
        return returnList;
    }

    private String getString(int n) {
        if (n % 3 == 0 && n % 5 == 0)
            return "FizzBuzz";
        if (n % 3 == 0)
            return "Fizz";
        if (n % 5 == 0)
            return "Buzz";

        return n + "";
    }
}
