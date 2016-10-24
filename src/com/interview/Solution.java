package com.interview;

/*
Sudoku is a game played by placing numbers from 1-9 in a 9x9 grid. For
an arrangment to be a proper solution three conditions must be
met. Each row of the grid must have exactly one of each of the digits
between 1-9. Each column must also have exactly one each of the digits
and each 3x3 sub-grid (taken by deviding the grid into a 3x3
arrangement of 3x3 cells vis.

      1 2 3 4 5 6 7 8 9
  ______________________
  1:  a|a|a|b|b|b|c|c|c
      -----------------
  2:  a|a|a|b|b|b|c|c|c
      -----------------
  3:  a|a|a|b|b|b|c|c|c
      -----------------
  4:  d|d|d|e|e|e|f|f|f
      -----------------
  5:  d|d|d|e|e|e|f|f|f
      -----------------
  6:  d|d|d|e|e|e|f|f|f
      -----------------
  7:  g|g|g|h|h|h|i|i|i
      -----------------
  8:  g|g|g|h|h|h|i|i|i
      -----------------
  9:  g|g|g|h|h|h|i|i|i

each letter represents a subgrouping that must have exactly one of
each of the digits.

implement the api to check to see if the given string is
  valid as a solution. the input string should contain exactly 81
  digits arranged row wise (i.e. the first nine char's are row 1, the
  next 9 (9-17) are row 2 etc.)
 */
class Solution {
    public static void main(String[] args) {
        Solution.validPuzzle("");
    }


    //Method to check if 9 digits are unique
    public static boolean hasUniqueNumbers(int[] numbers) {
        System.out.println("Entering hasUniqueNumbers");
        boolean[] presentArray = new boolean[10];
        for (int i : numbers) {
            if (presentArray[i] == true)
                return false;
            else {
                presentArray[i] = true;
            }
        }
        return true;
    }

    public static boolean validPuzzle(String inputString) {
        if (inputString.length() != 81)
            return false;

        //Step 1 break String into 9*9 array
        char[] c = inputString.toCharArray();
        int[][] inputArray = new int[9][9];
        for (int i = 0; i < 81; i++) {
            int row = Integer.parseInt("" + c[i]) / 9;
            int column = Integer.parseInt("" + c[i]) % 9;
            inputArray[row][column] = c[i];
        }


        // Steps 2 Verify if each row has unique numbers
        for (int i = 0; i < 9; i++) {
            int[] row = inputArray[i];
            if (hasUniqueNumbers(row) == false)
                return false;
        }


        // Step 3: Verify if each column has unique numbers
        for (int i = 0; i < 9; i++) {
            int[] column = new int[9];
            for (int[] a : inputArray)
                column[i] = a[i];

            if (hasUniqueNumbers(column) == false)
                return false;
        }

        return true;
    }
}
