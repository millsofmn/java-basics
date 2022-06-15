package com.millsofmn.codility;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. Rotation of the array means
 * that each element is shifted right by one index, and the last element of
 * the array is moved to the first place. For example, the rotation of array
 * A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one
 * index and 6 is moved to the first place).
 *
 * The goal is to rotate array A K times; that is, each element of A will be
 * shifted to the right K times.
 *
 * Write a function:
 *
 * class Solution { public int[] solution(int[] A, int K); }
 *
 * that, given an array A consisting of N integers and an integer K, returns
 * the array A rotated K times.
 *
 * For example, given
 *
 *     A = [3, 8, 9, 7, 6]
 *     K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 *
 *     [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 *     [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 *     [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * For another example, given
 *
 *     A = [0, 0, 0]
 *     K = 1
 * the function should return [0, 0, 0]
 *
 * Given
 *
 *     A = [1, 2, 3, 4]
 *     K = 4
 * the function should return [1, 2, 3, 4]
 *
 * Assume that:
 *
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
public class CyclicRotation {

    public static int[] solution(int[] A, int K){

        System.out.println("\nA = " + Arrays.toString(A));
        System.out.println("K = " + K);

        int tempLastElement;

        if(A.length > 0) {
            for (int i = 0; i < K; i++) {
                System.out.print(Arrays.toString(A) + " => ");

                tempLastElement = A[A.length - 1];

                for (int p = A.length - 1; p > 0; p--) {
                    A[p] = A[p - 1];
                }

                A[0] = tempLastElement;

                System.out.println(Arrays.toString(A));
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] array1 = {3, 8, 9, 7, 6};
        int rotations1 = 3;
        solution(array1, rotations1);

        int[] array2 = {};
        int rotations2 = 3;
        solution(array2, rotations2);

        int[] array3 = {1, 2, 3, 4};
        int rotations3 = 4;
        solution(array3, rotations3);
    }

}
