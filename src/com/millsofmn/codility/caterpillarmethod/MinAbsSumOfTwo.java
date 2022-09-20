package com.millsofmn.codility.caterpillarmethod;

import java.util.Arrays;

/**
 * Let A be a non-empty array consisting of N integers.
 * <p>
 * The abs sum of two for a pair of indices (P, Q) is the absolute value
 * |A[P] + A[Q]|, for 0 ≤ P ≤ Q < N.
 * <p>
 * For example, the following array A:
 * <p>
 * A[0] =  1
 * A[1] =  4
 * A[2] = -3
 * has pairs of indices (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2).
 * The abs sum of two for the pair (0, 0) is A[0] + A[0] = |1 + 1| = 2.
 * The abs sum of two for the pair (0, 1) is A[0] + A[1] = |1 + 4| = 5.
 * The abs sum of two for the pair (0, 2) is A[0] + A[2] = |1 + (−3)| = 2.
 * The abs sum of two for the pair (1, 1) is A[1] + A[1] = |4 + 4| = 8.
 * The abs sum of two for the pair (1, 2) is A[1] + A[2] = |4 + (−3)| = 1.
 * The abs sum of two for the pair (2, 2) is A[2] + A[2] = |(−3) + (−3)| = 6.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the
 * minimal abs sum of two for any pair of indices in this array.
 * <p>
 * For example, given the following array A:
 * <p>
 * A[0] =  1
 * A[1] =  4
 * A[2] = -3
 * the function should return 1, as explained above.
 * <p>
 * Given array A:
 * <p>
 * A[0] = -8
 * A[1] =  4
 * A[2] =  5
 * A[3] =-10
 * A[4] =  3
 * the function should return |(−8) + 5| = 3.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the
 * range [−1,000,000,000..1,000,000,000].
 */
public class MinAbsSumOfTwo {

    public static void main(String[] args) {
        System.out.println("1 => " + new MinAbsSumOfTwo().solution(new int[]{1, 4, -3})); // -3 1 4
        System.out.println("3 => " + new MinAbsSumOfTwo().solution(new int[]{-8, 4, 5, -10, 3})); // -10 -8 3 4 5
    }

    /**
     * 100%
     * https://app.codility.com/demo/results/training8E34NC-C9J/
     * Hints:
     * 1. lowest value of X + X will be the lowest
     * 2. highest value of -X + -X will be the lowest
     * 3. abs of 0 is 0
     * 4. mix of - & + numbers (hint to use a sort)
     * 5. caterpillar method of working an array
     *      a. move tail if the sum is > 0
     *      b. move head if the sum is < 0
     */
    public int solution(int[] A) {
        Arrays.sort(A);

        int lowestAbsSum = Integer.MAX_VALUE;
        int sum;

        int head = 0;
        int tail = A.length -1;

        while(head <= tail){
            sum = Math.abs(A[head] + A[tail]);

            if(sum < lowestAbsSum){
                lowestAbsSum = sum;
            }

            if(0 < A[head] + A[tail]){
                tail--;
            } else {
                head++;
            }

        }

        return lowestAbsSum;
    }

    /**
     * 100% correct, 14% performance
     * https://app.codility.com/demo/results/trainingTFJZ92-P3B/
     */
    public int solution1(int[] A) {
        int lowest = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            for (int x = i; x < A.length; x++) {
                result = Math.abs(A[i] + A[x]);

                if (result < lowest)
                    lowest = result;
            }
        }
        return lowest;
    }
}
