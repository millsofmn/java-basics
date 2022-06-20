package com.millsofmn.codility.countingelements;

import com.millsofmn.javabasics.collections.Arrays;

import java.util.HashMap;
import java.util.HashSet;

/**
 * A small frog wants to get to the other side of a river. The frog is
 * initially located on one bank of the river (position 0) and wants to get to
 * the opposite bank (position X+1). Leaves fall from a tree onto the surface
 * of the river.
 * <p>
 * You are given an array A consisting of N integers representing the falling
 * leaves. A[K] represents the position where one leaf falls at time K,
 * measured in seconds.
 * <p>
 * The goal is to find the earliest time when the frog can jump to the other
 * side of the river. The frog can cross only when leaves appear at every
 * position across the river from 1 to X (that is, we want to find the earliest
 * moment when all the positions from 1 to X are covered by leaves). You may
 * assume that the speed of the current in the river is negligibly small, i.e.
 * the leaves do not change their positions once they fall in the river.
 * <p>
 * For example, you are given integer X = 5 and array A such that:
 * <p>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 1
 * A[3] = 4
 * A[4] = 2
 * A[5] = 3
 * A[6] = 5
 * A[7] = 4
 * In second 6, a leaf falls into position 5. This is the earliest time when
 * leaves appear in every position across the river.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int X, int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers and integer X,
 * returns the earliest time when the frog can jump to the other side of the river.
 * <p>
 * If the frog is never able to jump to the other side of the river, the
 * function should return −1.
 * <p>
 * For example, given X = 5 and array A such that:
 * <p>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 1
 * A[3] = 4
 * A[4] = 2
 * A[5] = 3
 * A[6] = 5
 * A[7] = 4
 * the function should return 6, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N and X are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..X].
 */
public class FrogRiverOne {

    /**
     * Borrowed a hint/code from stack overflow
     * https://app.codility.com/demo/results/trainingRBR2WN-C8R/
     */
    public int solution(int X, int[]A){
        // how many hops are needed to cross?
        int hop = X;

        // initialize path across
        boolean[] path = new boolean[X+1];

        // loop through time array filling in path
        for(int i = 0; i < A.length; i++){

            // check if the leaf has already fallen there
            if(!path[A[i]]){

                // nope, fill in the location
                path[A[i]] = true;

                // reduce total hops by 1
                hop--;

                // if path is filled in return index from array when it happened
                if(hop == 0)
                    return i;
            }
        }

        return -1; // no path
    }

    /**
     * Correctness 100%, Performance 0%
     * https://app.codility.com/demo/results/trainingP8TPYV-DWE/
     */
    public int solution1(int X, int[]A){
        HashMap<Integer, Integer> path = new HashMap<>();
        path.put(0, 1); // shore

        for(int i = 0; i < A.length; i++){
            // add new leaf on path
            if(!path.containsKey(A[i]))
                path.put(A[i], 0);

            int leavesAtSpot = path.get(A[i]);

            path.put(A[i], leavesAtSpot += 1);

            // can frog cross now?
            for(int y = 0; y <= A.length; y++){
                if(!path.containsKey(y))
                    break;

                if(y == X)
                    return i;
            }
        }
        return -1; // no path
    }

    public static void main(String[] args) {
        System.out.println("0 => " + new FrogRiverOne().solution(1, new int[]{1}));
        System.out.println("6 => " + new FrogRiverOne().solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
        System.out.println("8 => " + new FrogRiverOne().solution(6, new int[]{1, 3, 1, 4, 2, 3, 5, 4, 6}));
        System.out.println("4 => " + new FrogRiverOne().solution(4, new int[]{1, 3, 1, 4, 2, 3, 5, 4, 6}));
        System.out.println("-1 => " + new FrogRiverOne().solution(7, new int[]{1, 3, 1, 4, 2, 3, 5, 4, 6}));
    }
}
