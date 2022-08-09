package com.millsofmn.codility.leader;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * An array A consisting of N integers is given. The dominator of array A is
 * the value that occurs in more than half of the elements of A.
 * <p>
 * For example, consider array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * The dominator of A is 3 because it occurs in 5 out of 8 elements of A
 * (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half
 * of 8.
 * <p>
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns index of any
 * element of array A in which the dominator of A occurs. The function should
 * return −1 if array A does not have a dominator.
 * <p>
 * For example, given array A such that
 * <p>
 * A[0] = 3    A[1] = 4    A[2] =  3
 * A[3] = 2    A[4] = 3    A[5] = -1
 * A[6] = 3    A[7] = 3
 * the function may return 0, 2, 4, 6 or 7, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range
 * [−2,147,483,648..2,147,483,647].
 */
public class Dominator {

    public static void main(String[] args) {
        System.out.println("0, 2, 4, 6, 7 => " + new Dominator().solutions(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
        System.out.println("-1 => " + new Dominator().solutions(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    /**
     * Udemy Solution
     */
    public int solutions(int[] A) {
        int consecutiveSize = 0;
        int candidate = 0;

        for (int item : A) {
            if (consecutiveSize == 0) {
                candidate = item;
                consecutiveSize += 1;
            } else if (candidate == item) {
                consecutiveSize += 1;
            } else {
                consecutiveSize -= 1;
            }
        }

        int occurance = 0;
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                occurance++;
                index = i;
            }
        }
        return occurance > A.length / 2.0 ? index : -1;
    }

    /**
     * Another hint using a candidate
     * https://app.codility.com/demo/results/trainingMZCYV9-DH2/
     */
    public int solutions4(int[] A) {
        int candidate = 0;
        int count = 0;
        int idx = -1;

        for (int i = 0; i < A.length; i++) {
            if (candidate == A[i]) {
                count++;

            } else if (count == 0) {
                candidate = A[i];
                count++;
                idx = i;

            } else {
                count--;
            }
        }
        if (count > 0) {
            int total = 0;
            for (int x : A) {
                if (x == candidate) total++;
            }

            if (total > A.length / 2)
                return idx;
        }
        return -1;
    }

    /**
     * Another hint with stack
     * https://app.codility.com/demo/results/trainingSPMFXG-TCU/
     */
    public int solutions3(int[] A) {
        Stack<Integer> stack = new Stack<>();

        for (int num : A) {

            if (!stack.isEmpty()) {
                int comparator = stack.pop();

                if (comparator == num) {
                    stack.push(num);
                }
            } else stack.push(num);
        }

        if (!stack.isEmpty()) {
            int count = 0;
            int leader = stack.pop();
            int idx = -1;

            for (int i = 0; i < A.length; i++) {
                if (A[i] == leader) {
                    count++;
                    idx = i;
                }
            }
            if (count > A.length / 2) {
                return idx;
            }
        }
        return -1;
    }

    /**
     * Udemy hint: 25%
     * https://app.codility.com/demo/results/training7YVMNF-U27/
     */
    public int solutions2(int[] A) {
        int idx = -1;

        for (int i = 0; i < A.length; i += 2) {
            int first = A[i];
            int second = A[i + 1];

            if (first != second)
                continue;
            else
                idx = i;
        }
        return idx;
    }

    /**
     * No Hint, 83%
     * https://app.codility.com/demo/results/trainingC9MZ8D-AVA/
     */
    public int solutions1(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int pos = -1;

        for (int i = 0; i < A.length; i++) {
            int count = map.getOrDefault(A[i], 0);
            count++;
            map.put(A[i], count);

            if (count > max) {
                max = count;
                pos = i;
            }
        }

        if (pos > (A.length / 2))
            return pos;
        else
            return -1;
    }

}
