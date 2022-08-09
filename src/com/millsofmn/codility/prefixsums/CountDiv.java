package com.millsofmn.codility.prefixsums;

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(int A, int B, int K); }
 * <p>
 * that, given three integers A, B and K, returns the number of integers
 * within the range [A..B] that are divisible by K, i.e.:
 * <p>
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * <p>
 * For example, for A = 6, B = 11 and K = 2, your function should return 3,
 * because there are three numbers divisible by 2 within the range [6..11],
 * namely 6, 8 and 10.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 */
public class CountDiv {

    public static void main(String[] args) {
        System.out.println("3 => " + new CountDiv().solution(6, 11, 2));
        System.out.println("20 => " + new CountDiv().solution(11, 345, 17));
        System.out.println("1 => " + new CountDiv().solution(0, 0, 11));
        System.out.println("0 => " + new CountDiv().solution(5, 7, 20));
    }

    /**
     * Udemy Solution
     */
    public int solution5(int A, int B, int K) {

        int lowerBound = (int) Math.ceil(A / (double) K);
        int upperBound = (int) Math.floor(B / (double) K);

        System.out.println(lowerBound + "/" + upperBound);
        return upperBound - lowerBound + 1;
    }

    /**
     *
     */
    public int solution(int A, int B, int K){
        int divs = 0;


        int lowerBound = A - A%K;
        int upperBound = B + B%K;


        return (upperBound-lowerBound)/K;
    }

    /**
     * 100% Correctness
     * https://app.codility.com/demo/results/training7FCF6K-AZ6/
     */
    public int solution1(int A, int B, int K) {
        int divs = 0;

        int i = A;

        while (i <= B) {
            if (i % K == 0) divs++;
            i++;
        }

        return divs;
    }
}
