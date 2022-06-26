package com.millsofmn.codility.countingelements;

import java.util.Arrays;

/**
 * You are given N counters, initially set to 0, and you have two possible
 * operations on them:
 * <p>
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty array A of M integers is given. This array represents
 * consecutive operations:
 * <p>
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * For example, given integer N = 5 and array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * the values of the counters after each consecutive operation will be:
 * <p>
 * (0, 0, 1, 0, 0)
 * (0, 0, 1, 1, 0)
 * (0, 0, 1, 2, 0)
 * (2, 2, 2, 2, 2)
 * (3, 2, 2, 2, 2)
 * (3, 2, 2, 3, 2)
 * (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int N, int[] A); }
 * <p>
 * that, given an integer N and a non-empty array A consisting of M integers,
 * returns a sequence of integers representing the values of the counters.
 * <p>
 * Result array should be returned as an array of integers.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * the function should return [3, 2, 2, 4, 2], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 */
public class MaxCounter {
    public static void main(String[] args) {
        System.out.println("3,2,2,4,2 => " + Arrays.toString(new MaxCounter().solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
        System.out.println("5 => " + Arrays.toString(new MaxCounter().solution(1, new int[]{1, 1, 1, 1, 4, 1})));
    }

    /**
     * Udemy Solution
     */
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        Arrays.fill(counters, 0);
        int start_line = 0;
        int current_max = 0;
        for (int i : A) {
            int x = i - 1;
            if (i > N) start_line = current_max;
            else if (counters[x] < start_line) counters[x] = start_line + 1;
            else counters[x] += 1;
            if (i <= N && counters[x] > current_max) current_max = counters[x];
        }
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < start_line) counters[i] = start_line;
        }
        return counters;
    }

    /**
     * 100% - 1 hint: moving the starting line
     * https://app.codility.com/demo/results/training5VUDE8-UZ8/
     */
    public int[] solution2(int N, int[] A) {
        int[] counters = new int[N];

        int startingLine = 0;
        int max = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] > N) {
                startingLine = max;
                continue;
            }

            if (counters[A[i] - 1] < startingLine) {
                counters[A[i] - 1] = startingLine + 1;

            } else {
                counters[A[i] - 1] += 1;
            }

            if (counters[A[i] - 1] > max) max = counters[A[i] - 1];

            System.out.println(Arrays.toString(counters));
        }

        for (int x = 0; x < counters.length; x++) {
            if (counters[x] < startingLine) counters[x] = startingLine;
        }

        return counters;
    }

    /**
     * 77% - timeout error for large arrays
     * https://app.codility.com/demo/results/training4RE2KJ-8SS/
     */
    public int[] solution1(int N, int[] A) {
        int[] counters = new int[N];
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > N) {
                for (int x = 0; x < counters.length; x++) {
                    counters[x] = max;
                }
            } else {
                counters[A[i] - 1] += 1;
                if (counters[A[i] - 1] > max) max = counters[A[i] - 1];
            }
            System.out.println(Arrays.toString(counters));
        }

        return counters;
    }

}
