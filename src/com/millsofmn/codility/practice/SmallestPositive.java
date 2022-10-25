package com.millsofmn.codility.practice;

import java.util.Arrays;

/**
 * This is a demo task.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class SmallestPositive {
    public static void main(String[] args) {
        System.out.println("5 => " + new SmallestPositive().solution(new int[]{1,3,6,4,1,2}));
        System.out.println("4 => " + new SmallestPositive().solution(new int[]{1,2,3}));
        System.out.println("1 => " + new SmallestPositive().solution(new int[]{-1,-3}));
    }

    /**
     * 100%
     * https://app.codility.com/c/feedback/demoTVX45F-E5F/
     */
    public int solution(int[] A){
        Arrays.sort(A);

        int missingValue = 1;

        for(int i = 0; i < A.length; i++){
            if(A[i] <= 0){
                continue;

            } else if(A[i] == missingValue) {
                missingValue = missingValue + 1;
            } else if(A[i] > missingValue){
                break;
            }
        }
        return missingValue;
    }
}
