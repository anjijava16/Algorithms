package com.leetcode;

import java.util.Stack;

/**
 * Created by sunilpatil on 11/13/16.
 */
public class Problem7 {


    public int reverse2(int n) {
        Stack<Integer> numberStack = new Stack<>();
        int x = n;
        if (Math.abs(n) < 0)
            return 0;
        while (Math.abs(x) >= 10) {
            numberStack.push(x % 10);
            x = x / 10;
        }

        long returnValue = x;
        long multiplier = 10;
        while (!numberStack.empty()) {
            int placeValue = numberStack.pop();
            long itSum = returnValue + (placeValue * multiplier);
            if (itSum < Integer.MAX_VALUE && itSum > Integer.MIN_VALUE)
                returnValue = returnValue + (placeValue * multiplier);
            else
                return 0;
            multiplier = multiplier * 10;
        }
        return (int) returnValue;
    }
}
