package com.millsofmn.codility.stacksandqueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * You are given two non-empty arrays A and B consisting of N integers. Arrays
 * A and B represent N voracious fish in a river, ordered downstream along the
 * flow of the river.
 * <p>
 * The fish are numbered from 0 to N − 1. If P and Q are two fish and P < Q,
 * then fish P is initially upstream of fish Q. Initially, each fish has a
 * unique position.
 * <p>
 * Fish number P is represented by A[P] and B[P]. Array A contains the sizes of
 * the fish. All its elements are unique. Array B contains the directions of
 * the fish. It contains only 0s and/or 1s, where:
 * <p>
 * 0 represents a fish flowing upstream,
 * 1 represents a fish flowing downstream.
 * If two fish move in opposite directions and there are no other (living) fish
 * between them, they will eventually meet each other. Then only one fish can
 * stay alive − the larger fish eats the smaller one. More precisely, we say
 * that two fish P and Q meet each other when P < Q, B[P] = 1 and B[Q] = 0, and
 * there are no living fish between them. After they meet:
 * <p>
 * If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
 * If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.
 * We assume that all the fish are flowing at the same speed. That is, fish
 * moving in the same direction never meet. The goal is to calculate the number
 * of fish that will stay alive.
 * <p>
 * For example, consider arrays A and B such that:
 * <p>
 * A[0] = 4    B[0] = 0
 * A[1] = 3    B[1] = 1
 * A[2] = 2    B[2] = 0
 * A[3] = 1    B[3] = 0
 * A[4] = 5    B[4] = 0
 * Initially all the fish are alive and all except fish number 1 are moving
 * upstream. Fish number 1 meets fish number 2 and eats it, then it meets fish
 * number 3 and eats it too. Finally, it meets fish number 4 and is eaten by
 * it. The remaining two fish, number 0 and 4, never meet and therefore stay
 * alive.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A, int[] B); }
 * <p>
 * that, given two non-empty arrays A and B consisting of N integers, returns
 * the number of fish that will stay alive.
 * <p>
 * For example, given the arrays shown above, the function should return 2, as
 * explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [0..1,000,000,000];
 * each element of array B is an integer that can have one of the following
 * values: 0, 1;
 * <p>
 * the elements of A are all distinct.
 */
public class Fish {

    public static void main(String[] args) {
        System.out.println("2 => " + new Fish().solution(new int[]{4, 8, 2, 6, 7}, new int[]{0, 1, 1, 0, 0}));
        System.out.println("2 => " + new Fish().solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
        System.out.println("1 => " + new Fish().solution(new int[]{6, 3, 5, 1, 2, 4}, new int[]{1, 1, 0, 1, 0, 0}));
        System.out.println("1 => " + new Fish().solution(new int[]{2, 6, 4, 3, 1, 5}, new int[]{1, 0, 1, 0, 1, 1}));
        System.out.println("2 => " + new Fish().solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
        System.out.println("5 => " + new Fish().solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 0, 0, 0, 1}));
        System.out.println("5 => " + new Fish().solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 0, 1, 1, 1}));
    }

    /**
     * Udemy Solution
     */
    public int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int survivors = 0;

        for (int i = 0; i < A.length; i++) {

            int weight = A[i];

            if (B[i] == 1) {
                stack.push(weight);

            } else {
                int weightDown = stack.isEmpty() ? -1 : stack.pop();

                while (weightDown != -1 && weightDown < weight)
                    weightDown = stack.isEmpty() ? -1 : stack.pop();

                if (weightDown == -1)
                    survivors += 1;
                else
                    stack.push(weightDown);
            }
        }
        return survivors + stack.size();
    }

    /**
     * with Udemy hint 100%
     * https://app.codility.com/demo/results/trainingCXHB8E-TBT/
     */
    public int solution3(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int count = A.length;

        for (int i = 0; i < A.length; i++) {
            int fish = A[i];
            int direction = B[i];

            if (direction == 1) {
                stack.add(fish);

            } else if (stack.size() > 0) {

                while (stack.size() > 0) {
                    int fishGoingRight = stack.peek();

                    if (fishGoingRight < fish) {
                        stack.pop();
                        count--;
                    } else {
                        count--;
                        break;
                    }
                }
            }
        }
        return count;
    }

    /**
     * After way to long thinking about it. 37%
     * https://app.codility.com/demo/results/trainingWAHCBT-KKJ/
     */
    public int solution1(int[] A, int[] B) {

        int fishGoingLeft = 0;
        int fishGoingRight = 0;
        int fishCount = B.length;

        for (int i = 0; i < A.length; i++) {
            int fish = A[i];
            int direction = B[i];

            if (direction == 0) {
                fishGoingLeft = fish;
            } else {
                fishGoingRight = fish;
            }

            if (fishGoingRight > 0 && fishGoingLeft > 0) {

                if (fishGoingLeft > fishGoingRight) {
                    fishCount--;
                    fishGoingRight = 0;

                } else if (fishGoingRight > fishGoingLeft) {
                    fishCount--;
                    fishGoingLeft = 0;
                }
            } else {
                fishGoingLeft = 0;
            }
        }

        return fishCount;
    }
}
