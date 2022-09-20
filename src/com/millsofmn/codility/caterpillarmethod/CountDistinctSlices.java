package com.millsofmn.codility.caterpillarmethod;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * An integer M and a non-empty array A consisting of N non-negative integers
 * are given. All integers in array A are less than or equal to M.
 * <p>
 * A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of
 * array A. The slice consists of the elements A[P], A[P + 1], ..., A[Q]. A
 * distinct slice is a slice consisting of only unique numbers. That is, no
 * individual number occurs more than once in the slice.
 * <p>
 * For example, consider integer M = 6 and array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 5
 * A[3] = 5
 * A[4] = 2
 * There are exactly nine distinct slices:
 * (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4) and (4, 4).
 * <p>
 * The goal is to calculate the number of distinct slices.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int M, int[] A); }
 * <p>
 * that, given an integer M and a non-empty array A consisting of N integers,
 * returns the number of distinct slices.
 * <p>
 * If the number of distinct slices is greater than 1,000,000,000, the function
 * should return 1,000,000,000.
 * <p>
 * For example, given integer M = 6 and array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 5
 * A[3] = 5
 * A[4] = 2
 * the function should return 9, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..M].
 */
public class CountDistinctSlices {

    public static void main(String[] args) {
        System.out.println("9 => " + new CountDistinctSlices().solution(6, new int[]{3, 4, 5, 5, 2}));
        System.out.println("39 => " + new CountDistinctSlices().solution(9, new int[]{2, 4, 1, 7, 4, 9, 7, 3, 5, 5, 8, 7, 1}));
    }

    /**
     * Codility Solutions 100%
     */
    public int solution(int M, int[] A){
        int totalSlices = 0;

        // the index of this array is the number of the slice thus preventing duplicate
        boolean[] inCurrentSlice = new boolean[M + 1];

        Arrays.fill(inCurrentSlice, false);
        int head = 0;

        for(int tail = 0; tail < A.length; tail++) {

            while (head < A.length && !inCurrentSlice[A[head]]) {
                inCurrentSlice[A[head]] = true;
                totalSlices += (head - tail) + 1;
                head += 1;

                if (totalSlices > 1000000000)
                    totalSlices = 1000000000;
            }
            inCurrentSlice[A[tail]] = false;
        }
        return totalSlices;
    }

    public int solution2(int M, int[] A) {
        ArrayList<Integer> duplicates = new ArrayList<>();

        int count = 0;

        for (int startIdx = 0; startIdx < A.length; startIdx++) {

            for (int endIdx = startIdx; endIdx < A.length; endIdx++) {
                if (duplicates.contains(A[endIdx])) {
                    duplicates.remove(duplicates.indexOf(A[startIdx]));
                    break;
                } else {
                    duplicates.add(A[endIdx]);
                    count++;
                }
            }
            duplicates = new ArrayList<>();
        }

        return count > 1000000000 ? 1000000000 : count;
    }

    /**
     * 100% correct 70% total
     * https://app.codility.com/demo/results/training6PY49G-2BG/
     */
    public int solution1(int M, int[] A) {

        int uniqueSlices = 0;

        for (int startIndex = 0; startIndex < A.length; startIndex++) {

            for (int endIndex = startIndex; endIndex < A.length; endIndex++) {

                if (startIndex == endIndex) {
                    uniqueSlices++;

                } else if (!containsDuplicates(startIndex, endIndex, A)) {
                    uniqueSlices++;

                } else {
                    break;
                }
            }
        }
        return uniqueSlices > 1000000000 ? 1000000000 : uniqueSlices;
    }

    public boolean containsDuplicates(int startIndex, int endIndex, int[] A) {
        for (int i = startIndex; i <= endIndex; i++) {
            for (int x = i + 1; x <= endIndex; x++) {
                if (A[i] == A[x]) {
                    return true;
                }
            }
        }
        return false;
    }

}
