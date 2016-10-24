package com.cci;

/**
 * Created by sunilpatil on 10/19/16.
 */
public class Chapter5 {

    public static void main(String[] argv) {
        Chapter5 chapter5 = new Chapter5();

        System.out.println(chapter5.convertToHexaDecimal(167));
        System.out.println(chapter5.convertFromHexToDec("4CB2C"));
        System.out.println(Character.getNumericValue('A') + " " + Character.getNumericValue('Z'));
        //     System.out.println(Math.pow(16,0));
        //     System.out.println(Math.pow(16,1));
        //    System.out.println(Math.pow(16,2));

    }

    public static int makeChange(int n, int denom) {
        int next_denom = 0;
        switch (denom) {
            case 25:
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5:
                next_denom = 1;
                break;
            case 1:
                return 1;
        }
        int ways = 0;
        for (int i = 0; i * denom <= n; i++) {
            ways += makeChange(n - i * denom, next_denom);
        }
        return ways;
    }

    public static void convertBinary(int num) {
        int binary[] = new int[40];
        int index = 0;
        while (num > 0) {
            binary[index++] = num % 2;
            num = num / 2;
        }
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(binary[i]);
        }
    }

    private String convertToHexaDecimal(int n) {
        StringBuffer s = new StringBuffer();
        int number = n;
        int remainder = 0;
        while (number >= 16) {
            remainder = number % 16;
            number = number / 16;
            s.append(getDecToHex(remainder));
        }
        s.append(getDecToHex(number));
        return reverseString(s.toString());
    }

    private String reverseString(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        int end = c.length - 1;
        while (start < end) {
            char temp = c[end];
            c[end] = c[start];
            c[start] = temp;
            start++;
            end--;
        }
        return new String(c);
    }


    private String getDecToHex(int n) {
        System.out.println("getHexEquivalent " + n);
        switch (n) {
            case 0:
                return "0";
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                throw new IllegalArgumentException();
        }
    }

    private int convertFromHexToDec(String hex) {
        int number = 0;
        char[] chars = hex.toCharArray();
        int counter = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            number = number + (getHexToDigital(chars[i]) * (int) Math.pow(16, counter++));
        }
        return number;
    }

    private int getHexToDigital(char c) {
        System.out.println("getHexToDigital " + c);
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                throw new IllegalArgumentException();
        }
    }
}
