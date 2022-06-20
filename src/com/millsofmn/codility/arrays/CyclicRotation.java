package com.millsofmn.codility.arrays;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. Rotation of the array means
 * that each element is shifted right by one index, and the last element of
 * the array is moved to the first place. For example, the rotation of array
 * A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one
 * index and 6 is moved to the first place).
 * <p>
 * The goal is to rotate array A K times; that is, each element of A will be
 * shifted to the right K times.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A, int K); }
 * <p>
 * that, given an array A consisting of N integers and an integer K, returns
 * the array A rotated K times.
 * <p>
 * For example, given
 * <p>
 * A = [3, 8, 9, 7, 6]
 * K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * <p>
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * For another example, given
 * <p>
 * A = [0, 0, 0]
 * K = 1
 * the function should return [0, 0, 0]
 * <p>
 * Given
 * <p>
 * A = [1, 2, 3, 4]
 * K = 4
 * the function should return [1, 2, 3, 4]
 * <p>
 * Assume that:
 * <p>
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
public class CyclicRotation {

    /**
     * Hint from Udemy
     * https://app.codility.com/demo/results/trainingKPPRQN-ZYX/
     */
    public static int[] solution(int[] A, int K) {
        int[] B = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int pos = (i + K) % A.length;
            B[pos] = A[i];
        }
        return B;
    }

    /**
     * No Hints
     * https://app.codility.com/demo/results/trainingSPJV7F-ZSQ/
     */
    public static int[] solution1(int[] A, int K) {

        int tempLastElement;

        if (A.length > 0) {
            for (int i = 0; i < K; i++) {

                tempLastElement = A[A.length - 1];

                for (int p = A.length - 1; p > 0; p--) {
                    A[p] = A[p - 1];
                }

                A[0] = tempLastElement;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] array1 = {3, 8, 9, 7, 6}; // [9, 7, 6, 3, 8]
        int rotations1 = 3;
        System.out.println(Arrays.toString(solution(array1, rotations1)));

        int[] array2 = {};
        int rotations2 = 3;
        System.out.println(Arrays.toString(solution(array2, rotations2)));

        int[] array3 = {1, 2, 3, 4}; // [1, 2, 3, 4]
        int rotations3 = 4;
        System.out.println(Arrays.toString(solution(array3, rotations3)));
    }

}
