package com.leetcode;

import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * Created by sunilpatil on 12/21/16.
 */
public class Problem66 {
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        int[] output = new int[l + 1];
        int currentIndex = l - 1;
        int carry = 0;
        while (currentIndex >= 0) {
            int newDigit = digits[currentIndex];
            int sum = newDigit;
            if (currentIndex == l - 1) {
                sum = sum + 1;
            } else {
                sum = sum + carry;
            }
            if (sum > 9) {
                carry = sum / 10;
                output[currentIndex + 1] = sum % 10;
            } else {
                carry = 0;
                output[currentIndex + 1] = sum;
            }
            currentIndex = currentIndex - 1;
        }
        if (carry != 0)
            output[0] = carry;
        else
            output = Arrays.copyOfRange(output, 1, output.length);
        return output;
    }


}
