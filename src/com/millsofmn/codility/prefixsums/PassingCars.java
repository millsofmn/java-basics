package com.millsofmn.codility.prefixsums;

/**
 * A non-empty array A consisting of N integers is given. The consecutive
 * elements of array A represent consecutive cars on a road.
 *
 * Array A contains only 0s and/or 1s:
 *
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where
 * 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is
 * traveling to the west.
 *
 * For example, consider array A such that:
 *
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A of N integers, returns the number of pairs
 * of passing cars.
 *
 * The function should return −1 if the number of pairs of passing cars exceeds
 * 1,000,000,000.
 *
 * For example, given:
 *
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 * the function should return 5, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 */
public class PassingCars {

    public static void main(String[] args) {
        System.out.println("5 => " + new PassingCars().solution(new int[]{0,1,0,1,1}));
    }

    /**
     * Udemy Solution
     */
    public int solution(int[] A){
        int[] suffixSum = new int[A.length + 1];
        int count = 0;
        for(int i = A.length -1; i >=0; i--){
            suffixSum[i] = A[i] + suffixSum[i+1];
            if(A[i] == 0) count += suffixSum[i];
            if(count > 1000000000) return -1;
        }

        return count;
    }

    /**
     * 100% Udemy hint; prefix sum of cars going west count the cars going east
     * There were a couple of iterations to parse out the edge cases
     * https://app.codility.com/demo/results/training5HBFPM-QPE/
     */
    public int solution2(int[] A){
        if(A.length>100000) return -1;

        long carsPassed = 0;

        int carsGoingWest = 0;

        for(int i = 0; i < A.length; i++){
            if(A[i] == 1) carsGoingWest++;
        }

        for(int x = 0; x < A.length; x++){
            if(A[x] == 0) {
                carsPassed += carsGoingWest;
            } else {
                carsGoingWest--;
            }
        }

        return carsPassed <= 1000000000 ? (int)carsPassed : -1;
    }

    /**
     * No Udemy hint : 50% Correct, 100% correctness
     * https://app.codility.com/demo/results/trainingYU833H-4UN/
     */
    public int solution1(int[] A){

        if(A.length>100000) return -1;

        int carsPassed = 0;

        for(int i = 0; i < A.length; i++){
            if(A[i] == 0){
                for(int x = i; x < A.length; x++){
                    if(A[x] == 1){
                        carsPassed++;
                    }
                }
            }
        }
        return carsPassed;
    }
}
