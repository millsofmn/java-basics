package com.millsofmn.codility.timecomplexity;

import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given. Array A represents
 * numbers on a tape.
 * <p>
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty
 * parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * <p>
 * The difference between the two parts is the value of:
 * |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * <p>
 * In other words, it is the absolute difference between the sum of the first
 * part and the sum of the second part.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * We can split this tape in four places:
 * <p>
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the minimal
 * difference that can be achieved.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * the function should return 1, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 */
public class TapeEquilibrium {

    public static void main(String[] args) {
        System.out.println("1 => " + new TapeEquilibrium().solution(new int[]{3, 1, 2, 4, 3}));
        System.out.println("2 => " + new TapeEquilibrium().solution(new int[]{3, 1}));
    }

    /**
     * Udemy Solution
     */
    public int solution(int[] A) {
        long totalSum = 0;
        for (int i : A) {
            totalSum += i;
        }

        long rightSum = totalSum;
        long leftSum = 0;

        long[] sumArray = new long[A.length];

        for (int y = 0; y < A.length; y++) {
            rightSum -= A[y];
            leftSum += A[y];

            sumArray[y] = Math.abs(leftSum - rightSum);
        }

        long lowestValue = Integer.MAX_VALUE;
        for (long x : sumArray) {
            if (x < lowestValue)
                lowestValue = x;
        }

        return (int) lowestValue;
    }

    /**
     * My solution no hints. Nice to see that I was thinking about it the
     * same as Udemy.
     * https://app.codility.com/demo/results/trainingADMJWW-V6P/
     */
    public int solution2(int[] A) {
        int totalSum = 0;
        for (int i : A) {
            totalSum += i;
        }

        int leftSum = 0;

        int[] sumArray = new int[A.length - 1];
        int lowestValue = Integer.MAX_VALUE;

        for (int y = 0; y < A.length - 1; y++) {
            totalSum -= A[y];
            leftSum += A[y];

            sumArray[y] = Math.abs(leftSum - totalSum);

            if (sumArray[y] < lowestValue)
                lowestValue = sumArray[y];
        }

        return (int) lowestValue;
    }

    /**
     * 80% Not correct for small
     * https://app.codility.com/demo/results/trainingFWWXQH-5BR/
     */
    public int solution1(int[] A) {
        long totalSum = 0;
        for (int i : A) {
            totalSum += i;
        }

        long rightSum = totalSum;
        long leftSum = 0;

        long[] sumArray = new long[A.length];

        for (int y = 0; y < A.length; y++) {
            rightSum -= A[y];
            leftSum += A[y];

            sumArray[y] = Math.abs(leftSum - rightSum);
        }

        long lowestValue = Integer.MAX_VALUE;
        for (long x : sumArray) {
            if (x < lowestValue)
                lowestValue = x;
        }

        return (int) lowestValue;
    }

}
