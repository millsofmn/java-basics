package com.millsofmn.codility.maxslice;

import java.util.Arrays;

/**
 * An array A consisting of N integers is given. It contains daily prices of a
 * stock share for a period of N consecutive days. If a single share was bought
 * on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the profit of such
 * transaction is equal to A[Q] − A[P], provided that A[Q] ≥ A[P]. Otherwise,
 * the transaction brings loss of A[P] − A[Q].
 * <p>
 * For example, consider the following array A consisting of six elements such that:
 * <p>
 * A[0] = 23171
 * A[1] = 21011
 * A[2] = 21123
 * A[3] = 21366
 * A[4] = 21013
 * A[5] = 21367
 * If a share was bought on day 0 and sold on day 2, a loss of 2048 would
 * occur because A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on
 * day 4 and sold on day 5, a profit of 354 would occur because
 * A[5] − A[4] = 21367 − 21013 = 354. Maximum possible profit was 356. It
 * would occur if a share was bought on day 1 and sold on day 5.
 * <p>
 * Write a function,
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers containing daily prices of
 * a stock share for a period of N consecutive days, returns the maximum
 * possible profit from one transaction during this period. The function
 * should return 0 if it was impossible to gain any profit.
 * <p>
 * For example, given array A consisting of six elements such that:
 * <p>
 * A[0] = 23171
 * A[1] = 21011
 * A[2] = 21123
 * A[3] = 21366
 * A[4] = 21013
 * A[5] = 21367
 * the function should return 356, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..400,000];
 * each element of array A is an integer within the range [0..200,000].
 */
public class MaxProfit {

    public static void main(String[] args) {
        System.out.println("356 => " + new MaxProfit().solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));
        System.out.println("0 => " + new MaxProfit().solution(new int[]{23171}));
        System.out.println("3 => " + new MaxProfit().solution(new int[]{23171, 23174}));
        System.out.println("0 => " + new MaxProfit().solution(new int[]{23174, 23171}));
        System.out.println("115 => " + new MaxProfit().solution(new int[]{114,132,119,91,84,29,61,76,38,21,9,63,45,68,81,124,118,78,44,59,80}));
    }

    /**
     * Udemy's solution
     */
    public int solution(int[] A){
        int globalMaxSum = 0;
        int localMaxSum = 0;
        for(int i = 1; i < A.length; i++){
            int d = A[i] - A[i-1];
            localMaxSum = Math.max(d, localMaxSum + d);
            globalMaxSum = Math.max(localMaxSum, globalMaxSum);
        }
        return globalMaxSum;
    }

    /**
     * Kadane's Algorithm Udemy Hint
     * https://app.codility.com/demo/results/training5GYZV3-7H7/
     */
    public int solution3(int[] A) {

        int globalMax = 0;
        int localMax = 0;
        int changeBetweenYesterdayAndToday = 0;
        int yesterdaysValue = 0;
        int todaysValue = 0;

        for (int i = 1; i < A.length; i++) {
            yesterdaysValue = A[i-1];
            todaysValue = A[i];

            changeBetweenYesterdayAndToday = todaysValue - yesterdaysValue;

            if(localMax + changeBetweenYesterdayAndToday > changeBetweenYesterdayAndToday){
                localMax += changeBetweenYesterdayAndToday;
            } else {
                localMax = changeBetweenYesterdayAndToday;
            }

            if(localMax > globalMax)
                globalMax = localMax;
        }

        return globalMax > 0 ? globalMax : 0;
    }

    /**
     * 66%
     * https://app.codility.com/demo/results/trainingQMSN5X-BKW/
     */
    public int solution2(int[] A) {
        int maxProfit = 0;

        for (int buyDay = 0; buyDay < A.length; buyDay++) {

            int buyAt = A[buyDay];
            int sellAt = 0;

            for (int sellDay = buyDay; sellDay < A.length; sellDay++) {
                if (sellAt < A[sellDay])
                    sellAt = A[sellDay];
            }

            int profit = sellAt - buyAt;
            if (profit > maxProfit) maxProfit = profit;
        }
        return maxProfit > 0 ? maxProfit : 0;
    }

    /**
     * 66%
     * https://app.codility.com/demo/results/trainingQTP2TW-5PG/
     */
    public int solution1(int[] A) {
        int maxProfit = 0;

        // iterate through days starting with day 1
        for (int buyDay = 0; buyDay < A.length; buyDay++) {

            // compute profit buying on buyDay selling on sellDay
            for (int sellDay = buyDay; sellDay < A.length; sellDay++) {
                int profit = A[sellDay] - A[buyDay];

                if (maxProfit < profit) maxProfit = profit;
            }
        }

        return maxProfit > 0 ? maxProfit : 0;
    }
}
