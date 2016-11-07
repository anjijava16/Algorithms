package com.codility;

/**
 * Created by sunilpatil on 11/6/16.
 */
public class Problem1 {
    public static void main(String[] argv) {
        Problem1 problem1 = new Problem1();
        System.out.println(problem1.solution(5, new int[]{5, 5, 1, 7, 2, 3, 5}));
        System.out.println(problem1.solution(5, new int[]{5, 5, 1, 7, 2, 3, 5}) == 4);
        System.out.println(problem1.solution(5, new int[]{5, 5, 5, 5}));
        System.out.println(problem1.solution(5, new int[]{1, 2, 3, 4}));
        System.out.println(problem1.solution(5, new int[]{1, 2, 3, 4, 5}));

    }

    public int solution(int X, int[] A) {
        int start = 0;
        int end = A.length - 1;

        while (start < end) {
            while (start < A.length && A[start] != X) {
                start++;
                if (start == A.length)
                    return start;
            }
            while (start < end && A[end] == X) {
                end--;
            }
            if (A[start] == X && A[end] != X)
                swap(A, start, end);
        }
        return start;
    }

    private void swap(int[] A, int f, int s) {
        int temp = A[f];
        A[f] = A[s];
        A[s] = temp;
    }


}
