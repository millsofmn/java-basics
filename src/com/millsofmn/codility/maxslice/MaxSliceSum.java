package com.millsofmn.codility.maxslice;

/**
 * A non-empty array A consisting of N integers is given. A pair of
 * integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.
 * The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the maximum sum
 * of any slice of A.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 3  A[1] = 2  A[2] = -6
 * A[3] = 4  A[4] = 0
 * the function should return 5 because:
 * <p>
 * (3, 4) is a slice of A that has sum 4,
 * (2, 2) is a slice of A that has sum −6,
 * (0, 1) is a slice of A that has sum 5,
 * no other slice of A has sum greater than (0, 1).
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..1,000,000];
 * each element of array A is an integer within the range
 * [−1,000,000..1,000,000];
 * <p>
 * the result will be an integer within the range
 * [−2,147,483,648..2,147,483,647].
 */
public class MaxSliceSum {

    public static void main(String[] args) {
        System.out.println("5 => " + new MaxSliceSum().solution(new int[]{3, 2, -6, 4, 0}));
        System.out.println("5 => " + new MaxSliceSum().solution(new int[]{-3, 2, -6, 4, 0}));
    }

    /**
     * Kadane's Algorithm from a Udemy Hint
     */
    public int solution(int[] A){
        int max = A[0];
        int localMax = 0;

        for(int i = 0; i < A.length; i++){

            int tempMax = localMax + A[i];

            if(tempMax > localMax){
                localMax = tempMax;
            } else {
                localMax = 0;
            }

            if(localMax > max)
                max = localMax;
        }
        return max;
    }

    /**
     * Brute force O(n^3)
     */
    public int solution1(int[] A) {
        int max = 0;

        for (int i = 0; i < A.length; i++) {

            for (int y = i; y <= A.length; y++) {
                int sum = 0;

                for (int x = i; x < y; x++) {
                    sum += A[x];
                }
                if (sum > max) max = sum;
            }
        }

        return max;
    }
}
