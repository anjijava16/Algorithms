package com.leetcode;

/**
 * This is a demo task. You can read about this task and its solutions in this blog post.
 * <p>
 * A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e.
 * A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
 * Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.
 * <p>
 * For example, consider the following array A consisting of N = 8 elements:
 * <p>
 * A[0] = -1
 * A[1] =  3
 * A[2] = -4
 * A[3] =  5
 * A[4] =  1
 * A[5] = -6
 * A[6] =  2
 * A[7] =  1
 * P = 1 is an equilibrium index of this array, because:
 * <p>
 * A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]
 * P = 3 is an equilibrium index of this array, because:
 * <p>
 * A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7]
 * P = 7 is also an equilibrium index, because:
 * <p>
 * A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0
 * and there are no elements with indices greater than 7.
 * <p>
 * P = 8 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a zero-indexed array A consisting of N integers, returns any of its equilibrium indices. The function should return −1 if no equilibrium index exists.
 * <p>
 * For example, given array A shown above, the function may return 1, 3 or 7, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 * Created by sunilpatil on 10/25/16.
 */
public class Solution {
    public static void main(String[] argv) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{-1, 3, -4, 5, 1, -6, 2, 1}));
        //  System.out.println(solution.solution(new int[]{1,2,1}));

    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        for (int i = 0; i < A.length; i++) {
            long lowerValue = getLowerSum(A, i);
            long higherValue = getHigherSum(A, i + 1);
            if (lowerValue == higherValue)
                return i;
        }
        return -1;
    }

    private long getLowerSum(int[] A, int end) {
        if (end == 0)
            return 0;
        long returnValue = 0;
        for (int i = 0; i < end; i++) {
            returnValue = returnValue + A[i];
        }
        return returnValue;
    }

    private long getHigherSum(int[] A, int start) {

        long returnValue = 0;
        for (int i = start; i < A.length; i++) {
            returnValue = returnValue + A[i];
        }
        return returnValue;
    }
}
