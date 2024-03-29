package com.millsofmn.codility.euclideanalgorithm;

/**
 * Two positive integers N and M are given. Integer N represents the number of
 * chocolates arranged in a circle, numbered from 0 to N − 1.
 * <p>
 * You start to eat the chocolates. After eating a chocolate you leave only a
 * wrapper.
 * <p>
 * You begin with eating chocolate number 0. Then you omit the next M − 1
 * chocolates or wrappers on the circle, and eat the following one.
 * <p>
 * More precisely, if you ate chocolate number X, then you will next eat the
 * chocolate with number (X + M) modulo N (remainder of division).
 * <p>
 * You stop eating when you encounter an empty wrapper.
 * <p>
 * For example, given integers N = 10 and M = 4. You will eat the following
 * chocolates: 0, 4, 8, 2, 6.
 * <p>
 * The goal is to count the number of chocolates that you will eat, following
 * the above rules.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int N, int M); }
 * <p>
 * that, given two positive integers N and M, returns the number of chocolates
 * that you will eat.
 * <p>
 * For example, given integers N = 10 and M = 4. the function should return 5,
 * as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N and M are integers within the range [1..1,000,000,000].
 */
public class ChocolateByNumbers {

    public static void main(String[] args) {
        System.out.println("5 => " + new ChocolateByNumbers().solution(10, 4));
        System.out.println("4 => " + new ChocolateByNumbers().solution(24, 6));
        System.out.println("25 => " + new ChocolateByNumbers().solution(25, 6));
    }

    /**
     * 100%
     * https://app.codility.com/demo/results/trainingFNUT7Z-3G4/
     */
    public int solution(int N, int M) {
        return  N / gcd(N, M);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * Total Score: 62% , Correctness: 100%
     * https://app.codility.com/demo/results/trainingRFK4V9-WKA/
     */
    public int solution2(int N, int M) {
        //(X + M) modulo N (remainder of division)
        int chocolateAte = 0;

        int[] chocolates = new int[N];
        for (int i = 0; i < chocolates.length; i++) {
            chocolates[i] = 1;
        }

        int idx = 0;
        while (chocolates[idx] != 0) {
            chocolates[idx] = 0;
            idx = (idx + M) % N;
            chocolateAte++;
        }

        return chocolateAte;
    }
}
