package com.millsofmn.codility.timecomplexity;

import java.util.Arrays;

/**
 * An array A consisting of N different integers is given. The array contains
 * integers in the range [1..(N + 1)], which means that exactly one element is
 * missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 */
public class PermMissingElem {

    /**
     * Solution from Udemy
     * https://app.codility.com/demo/results/trainingTZZ6G8-SUM/
     */
    public static int solution(int[] A){
        long actualSum = 0;
        for(int number: A)
            actualSum += number;

        long maxNumber = A.length + 1;
        long expectedSum = (maxNumber * (maxNumber + 1) / 2);

        return (int) (expectedSum - actualSum);
    }

    /**
     * With hint 2 from Udemy
     * 80%, failed on large_range
     * https://app.codility.com/demo/results/trainingPTG8WG-YVK/
     */
    public static int solution2(int[] A){
        int actualTotal = 0;
        int highest = A.length+1;

        for(int i = 0; i < A.length; i++){
            actualTotal += A[i];
        }

        int expectedTotal = (highest * (highest+1))/2;

        return expectedTotal - actualTotal;
    }

    /**
     * https://app.codility.com/demo/results/trainingRNU3M9-FX4/
     */
    public static int solution1(int[] A){
        Arrays.sort(A);

        int iterator = 1;

        for(int i = 0; i < A.length; i++){
            if(A[i] != iterator)
                return iterator;

            iterator++;
        }
        return iterator;
    }

    public static void main(String[] args) {
        int[] example = new int[]{2,3,1,5};
        System.out.println("4 => " + solution(example));

        int[] empty = new int[]{};
        System.out.println("1 => " + solution(empty));

        int[] single = new int[]{2};
        System.out.println("1 => " + solution(single));

        int[] A2 = new int[]{1,2,4,5,6,7,8,9,10,11,12};
        System.out.println("3 => " + solution(A2));

        int[] A3 = new int[]{1,2,4};
        System.out.println("3 => " + solution(A3));

        int[] A4 = new int[]{1,3};
        System.out.println("2 => " + solution(A4));

        int[] A5 = new int[]{3,2};
        System.out.println("1 => " + solution(A5));

        int[] A6 = new int[]{2,3,4,5,6,7,8,9,10,11,12};
        System.out.println("1 => " + solution(A6));

        int[] A7 = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        System.out.println("12 => " + solution(A7));


        int[] test = new int[]{1,2,3,4,5,7,8,9,10,11,12};
        System.out.println("6 => " + solution(test));
    }
}
