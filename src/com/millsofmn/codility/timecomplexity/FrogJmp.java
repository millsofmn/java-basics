package com.millsofmn.codility.timecomplexity;

/**
 * A small frog wants to get to the other side of the road. The frog is
 * currently located at position X and wants to get to a position greater than
 * or equal to Y. The small frog always jumps a fixed distance, D.
 *
 * Count the minimal number of jumps that the small frog must perform to reach
 * its target.
 *
 * Write a function:
 *
 * class Solution { public int solution(int X, int Y, int D); }
 *
 * that, given three integers X, Y and D, returns the minimal number of jumps
 * from position X to a position equal to or greater than Y.
 *
 * For example, given:
 *
 *   X = 10
 *   Y = 85
 *   D = 30
 * the function should return 3, because the frog will be positioned as follows:
 *
 * after the first jump, at position 10 + 30 = 40
 * after the second jump, at position 10 + 30 + 30 = 70
 * after the third jump, at position 10 + 30 + 30 + 30 = 100
 * Write an efficient algorithm for the following assumptions:
 *
 * X, Y and D are integers within the range [1..1,000,000,000];
 * X ≤ Y.
 */
public class FrogJmp {

    /**
     * Researched Answer
     * https://app.codility.com/demo/results/training4BWRVY-6YX/
     */
    public static int solution(int X, int Y, int D) {
        return ((Y - X + D - 1) / D); // this works because of stupid computer math and int rounding.
    }

    /**
     * https://app.codility.com/demo/results/training7BFR32-GYW/
     */
    public static int solution2(int X, int Y, int D){
        int totalDist = Y-X;
        int hops = totalDist/D;

        if((totalDist%D)>0){
            hops++;
        }

        return hops;
    }

    /**
     * Total Score 44%
     * https://app.codility.com/demo/results/training2VG399-GP2/
     */
    public static int solution1(int X, int Y, int D){
        int hops = 0;

        for (int dist = X; Y > dist; dist += D)
            hops++;

        return hops;
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 85;
        int d = 30;
        System.out.println("3 => " + solution(x, y, d));

        int x1 = 5;
        int y1 = 105;
        int d1 = 3;
        System.out.println("34 => " + solution(x1, y1, d1));

        int x2 = 0;
        int y2 = 0;
        int d2 = 3;
        System.out.println("0 => " + solution(x2, y2, d2));

        int x3 = 10;
        int y3 = 11;
        int d3 = 1;
        System.out.println("1 => " + solution(x3, y3, d3));

    }
}
